package br.com.gerenciador.assembleias.model;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import br.com.gerenciador.assembleias.controller.form.PayloadForm;
import br.com.gerenciador.assembleias.repository.DocumentRepository;

@Entity
public class Payload {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	@Enumerated(EnumType.STRING)
	private AccreditationTypeEnum accreditationType;

	@NotNull
	@NotEmpty
	@Size(min = 1)
	@Valid
	@OneToMany
	private List<Document> documents;

	public Payload(PayloadForm form, DocumentRepository documentRepository) {
		super();
		this.accreditationType = form.getAccreditation_type();
		this.documents = documentRepository.saveAll(
				form.getDocuments().stream().map(docForm -> new Document(docForm)).collect(Collectors.toList()));
	}

	public Payload(@NotNull AccreditationTypeEnum accreditationType,
			@NotNull @NotEmpty @Size(min = 1) @Valid List<Document> documents) {
		super();
		this.accreditationType = accreditationType;
		this.documents = documents;
	}

	public AccreditationTypeEnum getAccreditationType() {
		return accreditationType;
	}

	public void setAccreditationType(AccreditationTypeEnum accreditationType) {
		this.accreditationType = accreditationType;
	}

	public List<Document> getDocuments() {
		return documents;
	}

	public void setDocuments(List<Document> documents) {
		this.documents = documents;
	}

	public Long getId() {
		return id;
	}

	public Payload() {
		super();
	}

}
