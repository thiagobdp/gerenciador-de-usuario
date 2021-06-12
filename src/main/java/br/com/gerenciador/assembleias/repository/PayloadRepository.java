package br.com.gerenciador.assembleias.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.gerenciador.assembleias.model.Payload;

public interface PayloadRepository extends JpaRepository<Payload, Long> {

}
