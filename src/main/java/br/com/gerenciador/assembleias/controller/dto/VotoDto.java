package br.com.gerenciador.assembleias.controller.dto;

import java.time.LocalDateTime;

import br.com.gerenciador.assembleias.model.Voto;
import br.com.gerenciador.assembleias.model.VotoEnum;

public class VotoDto {

	private Long id;
	private Long cpf;
	private VotoEnum voto;
	private LocalDateTime dataHoraVoto;
	private Long pautaId;

	public VotoDto(Voto voto) {
		this.id = voto.getId();
		this.cpf = voto.getCpf();
		this.voto = voto.getVoto();
		this.dataHoraVoto = voto.getDataHoraVoto();
		this.pautaId = voto.getPauta().getId();
	}

	public static VotoDto converter(Voto voto) {
		return new VotoDto(voto);
	}

	public Long getId() {
		return id;
	}

	public Long getCpf() {
		return cpf;
	}

	public VotoEnum getVoto() {
		return voto;
	}

	public LocalDateTime getDataHoraVoto() {
		return dataHoraVoto;
	}

	public Long getPautaId() {
		return pautaId;
	}

}
