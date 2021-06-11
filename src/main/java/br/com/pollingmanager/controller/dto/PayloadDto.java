package br.com.pollingmanager.controller.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.com.pollingmanager.model.AccreditationTypeEnum;
import br.com.pollingmanager.model.Payload;

public class PayloadDto {

	private Long id;
	private AccreditationTypeEnum accreditationType;
	private List<DocumentDto> documents;

	public PayloadDto(Payload p) {
		super();
		this.id = p.getId();
		this.accreditationType = p.getAccreditationType();
		this.documents = p.getDocuments().stream().map(d -> new DocumentDto(d)).collect(Collectors.toList());
	}

	public Long getId() {
		return id;
	}

	public AccreditationTypeEnum getAccreditationType() {
		return accreditationType;
	}

	public List<DocumentDto> getDocuments() {
		return documents;
	}

}
