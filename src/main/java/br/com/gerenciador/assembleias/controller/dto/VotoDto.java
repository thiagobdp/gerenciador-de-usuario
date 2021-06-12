package br.com.gerenciador.assembleias.controller.dto;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.br.CPF;

import br.com.gerenciador.assembleias.model.Pauta;
import br.com.gerenciador.assembleias.model.VotoEnum;

public class VotoDto {

	private Long cpf;
	private VotoEnum voto;
	private LocalDateTime dataHoraVoto;
	private Pauta pauta;


}
