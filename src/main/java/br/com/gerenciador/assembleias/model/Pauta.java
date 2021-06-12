package br.com.gerenciador.assembleias.model;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import br.com.gerenciador.assembleias.controller.form.AbreSessaoForm;
import br.com.gerenciador.assembleias.controller.form.PautaForm;

@Entity
public class Pauta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	@NotBlank
	@Size(min = 5)
	private String titulo;
	private String descricao;

	private LocalDateTime inicioSessao;
	private LocalDateTime fimSessao;

	private Long votosSim = 0L;
	private Long votosNao = 0L;

	// usar para verificar as sessoes que precisam ser analisadas
	@NotNull
	private Boolean sessaoFechada = false;

	@OneToMany(mappedBy = "pauta")
	private List<Voto> votos;

	public Pauta(@Valid PautaForm pautaForm) {
		this.titulo = pautaForm.getTitulo();
		this.descricao = pautaForm.getDescricao();
	}

	public Pauta() {
	}

	public Long getId() {
		return id;
	}

	public String getTitulo() {
		return titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public LocalDateTime getInicioSessao() {
		return inicioSessao;
	}

	public LocalDateTime getFimSessao() {
		return fimSessao;
	}

	public Boolean getSessaoFechada() {
		return sessaoFechada;
	}

	public List<Voto> getVotos() {
		return votos;
	}

	/**
	 * Abre a sessão atribuindo a hora de início e fim
	 * @param abreSessaoForm
	 */
	public void abreSessao(AbreSessaoForm abreSessaoForm) {
		this.inicioSessao = LocalDateTime.now();
		LocalDateTime fimSessao = this.inicioSessao;

		if (abreSessaoForm != null) {

			if (abreSessaoForm.getDuracaoEmMinutos() != null) {
				fimSessao = fimSessao.plusMinutes(abreSessaoForm.getDuracaoEmMinutos());
			}
			if (abreSessaoForm.getDuracaoEmHoras() != null) {
				fimSessao = fimSessao.plusHours(abreSessaoForm.getDuracaoEmHoras());
			}
			this.fimSessao = fimSessao;

		} else {
			this.fimSessao = fimSessao.plusMinutes(1);
		}
	}

	/**
	 * Soma os votos e armazena o resultado final para realizar a soma somente uma
	 * vez Fecha a sessão.
	 */
	public void contabilizaVotosEFechaSessao() {
		this.sessaoFechada = true;
		if (this.votosSim.compareTo(0L) == 0 && this.votosSim.compareTo(0L) == 0) {
			this.votos.stream().forEach(v -> {
				if (v.getVoto().compareTo(VotoEnum.SIM) == 0) {
					++this.votosSim;
				} else {
					++this.votosNao;
				}
			});
		}
	}
}
