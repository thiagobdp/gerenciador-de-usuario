package br.com.gerenciador.assembleias.controller.form;

import javax.validation.constraints.NotBlank;

public class PautaForm {

	@NotBlank
	private String titulo;

	private String descricao;

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

}
