package br.com.useraccreditation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.useraccreditation.model.Document;

public interface DocumentRepository extends JpaRepository<Document, Long> {

}
