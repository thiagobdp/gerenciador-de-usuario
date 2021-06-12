package br.com.gerenciador.assembleias.controller.dto;

import java.time.LocalDateTime;

import br.com.gerenciador.assembleias.model.Pauta;

public class PautaDetalhesDto {

	private Long id;
	private String titulo;
	private String descricao;
	private LocalDateTime inicioSessao;
	private LocalDateTime fimSessao;
	private Long qtdVotosSim;
	private Long qtdVotosNao;
	private Boolean sessaoFechada;

	public static PautaDetalhesDto converter(Pauta pauta) {
		PautaDetalhesDto dto = new PautaDetalhesDto();
		dto.setId(pauta.getId());
		dto.setTitulo(pauta.getTitulo());
		dto.setDescricao(pauta.getDescricao());
		dto.setDescricao(pauta.getDescricao());
		dto.setInicioSessao(pauta.getInicioSessao());
		dto.setFimSessao(pauta.getFimSessao());
		dto.setQtdVotosSim(pauta.getQtdVotosSim());
		dto.setQtdVotosNao(pauta.getQtdVotosNao());
		dto.setSessaoFechada(pauta.getSessaoFechada());		
		return dto;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public LocalDateTime getInicioSessao() {
		return inicioSessao;
	}

	public void setInicioSessao(LocalDateTime inicioSessao) {
		this.inicioSessao = inicioSessao;
	}

	public LocalDateTime getFimSessao() {
		return fimSessao;
	}

	public void setFimSessao(LocalDateTime fimSessao) {
		this.fimSessao = fimSessao;
	}

	public Long getQtdVotosSim() {
		return qtdVotosSim;
	}

	public void setQtdVotosSim(Long qtdVotosSim) {
		this.qtdVotosSim = qtdVotosSim;
	}

	public Long getQtdVotosNao() {
		return qtdVotosNao;
	}

	public void setQtdVotosNao(Long qtdVotosNao) {
		this.qtdVotosNao = qtdVotosNao;
	}

	public Boolean getSessaoFechada() {
		return sessaoFechada;
	}

	public void setSessaoFechada(Boolean sessaoFechada) {
		this.sessaoFechada = sessaoFechada;
	}

}
