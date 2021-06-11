package br.com.pollingmanager.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.com.pollingmanager.controller.form.DocumentForm;
import br.com.pollingmanager.repository.DocumentRepository;

@Entity
public class Document {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	@NotEmpty
	private String name;

	@NotNull
	@NotEmpty
	private String mimeType;

	@NotNull
	@NotEmpty
	private String content;

	public Document(DocumentForm form) {
		super();
		this.name = form.getName();
		this.mimeType = form.getMime_type();
		this.content = form.getContent();
	}

	public Document(@NotNull @NotEmpty String name, @NotNull @NotEmpty String mimeType,
			@NotNull @NotEmpty String content) {
		super();
		this.name = name;
		this.mimeType = mimeType;
		this.content = content;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMimeType() {
		return mimeType;
	}

	public void setMimeType(String mimeType) {
		this.mimeType = mimeType;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Document() {
		super();
	}

	public static Document converter(DocumentForm docForm, DocumentRepository documentRepository) {
		Document doc = new Document(docForm);
		return documentRepository.save(doc);
	}
}
