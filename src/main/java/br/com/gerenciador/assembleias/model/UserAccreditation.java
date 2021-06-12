package br.com.gerenciador.assembleias.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import br.com.gerenciador.assembleias.controller.form.UserAccreditationForm;
import br.com.gerenciador.assembleias.repository.DocumentRepository;
import br.com.gerenciador.assembleias.repository.PayloadRepository;

@Entity
public class UserAccreditation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String userId;
	private Boolean accreditaded;

	@OneToOne
	private Payload payload;

	public UserAccreditation() {
		super();
	}

	public UserAccreditation(UserAccreditationForm form, Boolean accreditaded, DocumentRepository documentRepository,
			PayloadRepository payloadRepository) {
		super();
		this.userId = form.getUser_id();
		this.accreditaded = accreditaded;
		this.payload = payloadRepository.save(new Payload(form.getPayload(), documentRepository));
	}

	public UserAccreditation(String userId, Boolean accreditaded) {
		super();
		this.userId = userId;
		this.accreditaded = accreditaded;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Boolean getAccreditaded() {
		return accreditaded;
	}

	public void setAccreditaded(Boolean accreditaded) {
		this.accreditaded = accreditaded;
	}

	public Payload getPayload() {
		return payload;
	}

}
