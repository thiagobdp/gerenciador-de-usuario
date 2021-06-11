package br.com.pollingmanager.controller;

import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.pollingmanager.controller.dto.UserAccreditationDto;
import br.com.pollingmanager.controller.form.UserAccreditationForm;
import br.com.pollingmanager.model.Document;
import br.com.pollingmanager.model.UserAccreditation;
import br.com.pollingmanager.repository.DocumentRepository;
import br.com.pollingmanager.repository.PayloadRepository;
import br.com.pollingmanager.repository.UserAccreditationRepository;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserAccreditationRepository userAccreditationRepository;

	@Autowired
	PayloadRepository payloadRepository;

	@Autowired
	DocumentRepository documentRepository;

	/**
	 * Receives documents to accreditate an investor. In the first request to a new
	 * user_id, save the user (investor) as accreditated=true. In the next requests
	 * for an existing user_id, it reverses the previous value of boolean
	 * accreditated and updates data base
	 * 
	 * @param user
	 * @return Success: always true.
	 */
	@Transactional
	@PostMapping(path = "accreditation", consumes = { "application/json" })
	public UserAccreditationDto accreditation(@RequestBody @Valid UserAccreditationForm userForm) {

		UserAccreditation userAcc = userAccreditationRepository.findByUserId(userForm.getUser_id());
		if (userAcc == null) {
			userAcc = userAccreditationRepository
					.save(new UserAccreditation(userForm, true, documentRepository, payloadRepository));
		} else {
			// reverses the value
			userAcc.setAccreditaded(!userAcc.getAccreditaded());
			// add documents to user
			userAcc.getPayload().getDocuments().addAll(userForm.getPayload().getDocuments().stream()
					.map(docForm -> Document.converter(docForm, documentRepository)).collect(Collectors.toList()));
		}

		return new UserAccreditationDto(true, userAcc.getAccreditaded());
	}

}
