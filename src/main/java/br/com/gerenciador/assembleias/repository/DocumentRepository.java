package br.com.gerenciador.assembleias.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.gerenciador.assembleias.model.Document;

public interface DocumentRepository extends JpaRepository<Document, Long> {

}
