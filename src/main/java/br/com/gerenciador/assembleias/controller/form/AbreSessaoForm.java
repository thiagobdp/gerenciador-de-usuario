package br.com.gerenciador.assembleias.controller.form;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

public class AbreSessaoForm {

	@Min(1) @Max(23)
	private Long duracaoEmHoras;
	
	@Min(1) @Max(59)
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
