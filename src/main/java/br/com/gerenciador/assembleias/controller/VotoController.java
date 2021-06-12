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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.gerenciador.assembleias.controller.dto.VotoDto;
import br.com.gerenciador.assembleias.controller.form.VotoForm;
import br.com.gerenciador.assembleias.model.Pauta;
import br.com.gerenciador.assembleias.model.Voto;
import br.com.gerenciador.assembleias.repository.PautaRepository;
import br.com.gerenciador.assembleias.repository.VotoRepository;

@RestController
@RequestMapping("/voto")
public class VotoController {

	@Autowired
	PautaRepository pautaRepository;

	@Autowired
	VotoRepository votoRepository;

	@GetMapping()
	public List<VotoDto> listar() {
		return votoRepository.findAll().stream().map(voto -> VotoDto.converter(voto)).collect(Collectors.toList());
	}

	/**
	 * Realiza do voto.
	 * 
	 * @param id
	 * @param votoForm
	 * @param uriBuilder
	 * @return
	 */
	@Transactional
	@PostMapping(consumes = { "application/json" }, value = "/votar")
	public ResponseEntity<VotoDto> votar(@RequestBody @Valid VotoForm votoForm, UriComponentsBuilder uriBuilder) {

		Optional<Pauta> opt = pautaRepository.findById(votoForm.getIdPauta());
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
