package br.com.gerenciador.assembleias.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.br.CPF;

@Entity
public class Voto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	@CPF
	private Long cpf;

	@NotBlank
	private VotoEnum voto;

	@NotBlank
	private LocalDateTime dataHoraVoto;

	@NotBlank
	@ManyToOne
	private Pauta pauta;

}
