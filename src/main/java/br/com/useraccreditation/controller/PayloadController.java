package br.com.useraccreditation.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.useraccreditation.controller.dto.PayloadDto;
import br.com.useraccreditation.model.Payload;
import br.com.useraccreditation.repository.DocumentRepository;
import br.com.useraccreditation.repository.PayloadRepository;
import br.com.useraccreditation.repository.UserAccreditationRepository;

@RestController
@RequestMapping("/payload")
public class PayloadController {

	@Autowired
	UserAccreditationRepository userAccreditationRepository;

	@Autowired
	PayloadRepository payloadRepository;

	@Autowired
	DocumentRepository documentRepository;
	
	@GetMapping
	public List<PayloadDto> payload() {

		List<Payload> payloadLst = payloadRepository.findAll();

		return payloadLst.stream().map(p -> new PayloadDto(p)).collect(Collectors.toList());
	}

}
