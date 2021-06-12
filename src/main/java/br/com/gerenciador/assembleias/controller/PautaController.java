package br.com.gerenciador.assembleias.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.gerenciador.assembleias.controller.dto.PautaDto;
import br.com.gerenciador.assembleias.controller.dto.SessaoAbertaDto;
import br.com.gerenciador.assembleias.controller.dto.VotoDto;
import br.com.gerenciador.assembleias.controller.form.AbreSessaoForm;
import br.com.gerenciador.assembleias.controller.form.PautaForm;
import br.com.gerenciador.assembleias.controller.form.VotoForm;
import br.com.gerenciador.assembleias.model.Pauta;
import br.com.gerenciador.assembleias.model.Voto;
import br.com.gerenciador.assembleias.repository.PautaRepository;
import br.com.gerenciador.assembleias.repository.VotoRepository;

@RestController
@RequestMapping("/pauta")
public class PautaController {

	@Autowired
	PautaRepository pautaRepository;

	@Autowired
	VotoRepository votoRepository;

	@GetMapping(consumes = { "application/json" })
	public List<PautaDto> listar() {
		return pautaRepository.findAll().stream().map(pauta -> PautaDto.converter(pauta)).collect(Collectors.toList());
	}

	/**
	 * Cadastra uma nova pauta. Permite títulos e descrições repetidas.
	 * 
	 * @param pautaForm
	 * @return
	 */
	@Transactional
	@PostMapping(consumes = { "application/json" })
	public PautaDto cadastrar(@RequestBody @Valid PautaForm pautaForm) {
		return PautaDto.converter(pautaRepository.save(new Pauta(pautaForm)));
	}

	/**
	 * Abre a sessão da Pauta. Caso já está aberta ou não encontra a Pauta, retorna
	 * erro.
	 * 
	 * @param pautaForm
	 * @return
	 */
	@Transactional
	@PutMapping(consumes = { "application/json" }, value = "/{id}/abrirsessao")
	public ResponseEntity<SessaoAbertaDto> abrirSessao(@PathVariable Long id,
			@RequestBody(required = false) @Valid AbreSessaoForm abreSessaoForm) {

		Optional<Pauta> opt = pautaRepository.findById(id);
		if (opt.isEmpty()) {
			return ResponseEntity.notFound().build();
		}

		Pauta pauta = opt.get();
		if (pauta.getInicioSessao() != null) {
			throw new IllegalStateException("Sessão já está aberta.");
		}

		pauta.abreSessao(abreSessaoForm);

		return ResponseEntity.ok(SessaoAbertaDto.converter(pauta));

	}

	@Transactional
	@PutMapping(consumes = { "application/json" }, value = "/{id}/votar")
	public ResponseEntity<VotoDto> votar(@PathVariable Long id, @RequestBody @Valid VotoForm votoForm,
			UriComponentsBuilder uriBuilder) {

		Optional<Pauta> opt = pautaRepository.findById(id);
		if (opt.isEmpty()) {
			return ResponseEntity.notFound().build();
		}

		Pauta pauta = opt.get();
		if (!pauta.isSessaoIniciada()) {
			throw new IllegalStateException("Não é possível votar pois a sessão ainda não foi aberta.");
		}

		if (pauta.getSessaoFechada()) {
			throw new IllegalStateException("Não é possível votar pois a sessão já está fechada.");
		}

		Voto voto = Voto.votar(votoForm, pauta);
		if (voto == null) {
			throw new IllegalStateException(
					"Não é possível votar pois o CPF:" + votoForm.getCpf() + " já realizou o voto.");
		}

		Voto votoSalvo = this.votoRepository.save(voto);
		URI uri = uriBuilder.path("/voto/{id}").buildAndExpand(votoSalvo.getId()).toUri();
		return ResponseEntity.created(uri).body(new VotoDto(voto));

	}

}
