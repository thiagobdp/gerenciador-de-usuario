package br.com.gerenciador.assembleias.controller.form;

import javax.validation.constraints.NotNull;

import br.com.gerenciador.assembleias.model.VotoEnum;

public class VotoForm {

	private Long cpf;
	private Long idPauta;

	@NotNull
	private VotoEnum voto;

	public Long getCpf() {
		return cpf;
	}

	public void setCpf(Long cpf) {
		this.cpf = cpf;
	}

	public VotoEnum getVoto() {
		return voto;
	}

	public void setVoto(VotoEnum voto) {
		this.voto = voto;
	}

	public Long getIdPauta() {
		return idPauta;
	}

	public void setIdPauta(Long idPauta) {
		this.idPauta = idPauta;
	}

}
