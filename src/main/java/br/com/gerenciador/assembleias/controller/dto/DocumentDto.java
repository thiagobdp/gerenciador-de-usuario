package br.com.gerenciador.assembleias.controller.dto;

import br.com.gerenciador.assembleias.model.Document;

public class DocumentDto {

	private Long id;
	private String name;
	private String mimeType;
	private String content;

	public DocumentDto(Document d) {
		super();
		this.id = d.getId();
		this.name = d.getName();
		this.mimeType = d.getMimeType();
		this.content = d.getContent();
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getMimeType() {
		return mimeType;
	}

	public String getContent() {
		return content;
	}

}
