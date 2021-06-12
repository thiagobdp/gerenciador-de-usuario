package br.com.gerenciador.assembleias.controller.form;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.br.CPF;

import br.com.gerenciador.assembleias.model.VotoEnum;

public class VotoForm {

	@NotBlank
	@CPF
	private Long cpf;

	@NotBlank
	private VotoEnum voto;

	@NotBlank	
	private Long idPauta;

}
