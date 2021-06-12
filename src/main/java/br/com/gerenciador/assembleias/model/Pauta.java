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

	public void setInicioSessao(LocalDateTime inicioSessao) {
		this.inicioSessao = inicioSessao;
	}

	public void setFimSessao(LocalDateTime fimSessao) {
		this.fimSessao = fimSessao;
	}

}
