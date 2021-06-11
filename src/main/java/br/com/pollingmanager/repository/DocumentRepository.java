package br.com.pollingmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.pollingmanager.model.Document;

public interface DocumentRepository extends JpaRepository<Document, Long> {

}
