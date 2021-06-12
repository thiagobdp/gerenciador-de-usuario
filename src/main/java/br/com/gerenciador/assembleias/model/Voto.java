package br.com.gerenciador.assembleias.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.br.CPF;

@Entity
public class Voto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	@NotBlank
	@CPF
	private Long cpf;

	@NotNull
	@NotBlank
	private VotoEnum voto;

	@NotNull
	@NotBlank
	private LocalDateTime dataHoraVoto;

	@NotNull
	@NotBlank
	@ManyToOne
	private Pauta pauta;

}
