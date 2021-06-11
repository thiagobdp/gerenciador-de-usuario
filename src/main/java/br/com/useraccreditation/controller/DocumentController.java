package br.com.useraccreditation.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.useraccreditation.controller.dto.DocumentDto;
import br.com.useraccreditation.model.Document;
import br.com.useraccreditation.repository.DocumentRepository;

@RestController
@RequestMapping("/document")
public class DocumentController {

	@Autowired
	DocumentRepository documentRepository;

	@GetMapping
	public List<DocumentDto> document() {

		List<Document> docLst = documentRepository.findAll();

		return docLst.stream().map(d -> new DocumentDto(d)).collect(Collectors.toList());
	}

}
