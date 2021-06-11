package br.com.pollingmanager.controller.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class DocumentForm {

	@NotNull
	@NotEmpty
	private String name;

	@NotNull
	@NotEmpty
	private String mime_type;

	@NotNull
	@NotEmpty
	private String content;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMime_type() {
		return mime_type;
	}

	public void setMime_type(String mime_type) {
		this.mime_type = mime_type;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}
