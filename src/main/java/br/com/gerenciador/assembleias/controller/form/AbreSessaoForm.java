package br.com.gerenciador.assembleias.controller.form;

import javax.validation.constraints.NotNull;

public class AbreSessaoForm {

	@NotNull
	private Long duracaoEmHoras;
	
	@NotNull
	private Long duracaoEmMinutos;

	public Long getDuracaoEmHoras() {
		return duracaoEmHoras;
	}

	public void setDuracaoEmHoras(Long duracaoEmHoras) {
		this.duracaoEmHoras = duracaoEmHoras;
	}

	public Long getDuracaoEmMinutos() {
		return duracaoEmMinutos;
	}

	public void setDuracaoEmMinutos(Long duracaoEmMinutos) {
		this.duracaoEmMinutos = duracaoEmMinutos;
	}

}
