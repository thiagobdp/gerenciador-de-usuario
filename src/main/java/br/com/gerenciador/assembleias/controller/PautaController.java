package br.com.gerenciador.assembleias.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pauta")
public class PautaController {

//	@Autowired
//	UserAccreditationRepository userAccreditationRepository;
//
//	@Autowired
//	PayloadRepository payloadRepository;
//
//	@Autowired
//	DocumentRepository documentRepository;

	/**
	 * Receives documents to accreditate an investor. In the first request to a new
	 * user_id, save the user (investor) as accreditated=true. In the next requests
	 * for an existing user_id, it reverses the previous value of boolean
	 * accreditated and updates data base
	 * 
	 * @param user
	 * @return Success: always true.
	 */
//	@Transactional
//	@PostMapping(path = "accreditation", consumes = { "application/json" })
//	public UserAccreditationDto accreditation(@RequestBody @Valid UserAccreditationForm userForm) {
//
//		UserAccreditation userAcc = userAccreditationRepository.findByUserId(userForm.getUser_id());
//		if (userAcc == null) {
//			userAcc = userAccreditationRepository
//					.save(new UserAccreditation(userForm, true, documentRepository, payloadRepository));
//		} else {
//			// reverses the value
//			userAcc.setAccreditaded(!userAcc.getAccreditaded());
//			// add documents to user
//			userAcc.getPayload().getDocuments().addAll(userForm.getPayload().getDocuments().stream()
//					.map(docForm -> Document.converter(docForm, documentRepository)).collect(Collectors.toList()));
//		}
//
//		return new UserAccreditationDto(true, userAcc.getAccreditaded());
//	}

}
