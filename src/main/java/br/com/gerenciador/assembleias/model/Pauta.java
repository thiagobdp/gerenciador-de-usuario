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

	private Long qtdVotosSim = 0L;
	private Long qtdVotosNao = 0L;

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
		this.verificaSeFechaSessao();
		return sessaoFechada;
	}

	public Long getQtdVotosSim() {
		this.verificaSeFechaSessao();
		return qtdVotosSim;
	}

	public Long getQtdVotosNao() {
		this.verificaSeFechaSessao();
		return qtdVotosNao;
	}

	public List<Voto> getVotos() {
		return votos;
	}

	/**
	 * Abre a sessão atribuindo a hora de início e fim
	 * 
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

	public Boolean isSessaoIniciada() {
		return this.inicioSessao == null ? false : true;
	}

	/**
	 * Verifica se deve fechar a sessão. Caso esteja aberta porém já tenha passado o
	 * horário de fechamento, realiza o fechamento e calcula o resultado dos votos *
	 */
	private void verificaSeFechaSessao() {
		if (!this.sessaoFechada) {
			if (this.fimSessao.isAfter(LocalDateTime.now())) {
				this.sessaoFechada = true;
				this.contabilizaVotos();
			}
		}
	}

	/**
	 * Soma os votos e armazena o resultado final. Assim realizar a soma somente uma
	 * vez e armazena a contagem nas variáveis.
	 */
	private void contabilizaVotos() {
		if (this.qtdVotosSim.compareTo(0L) == 0 && this.qtdVotosSim.compareTo(0L) == 0) {
			this.votos.stream().forEach(v -> {
				if (v.getVoto().compareTo(VotoEnum.SIM) == 0) {
					++this.qtdVotosSim;
				} else {
					++this.qtdVotosNao;
				}
			});
		}
	}
}
