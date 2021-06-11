package br.com.useraccreditation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.useraccreditation.model.Payload;

public interface PayloadRepository extends JpaRepository<Payload, Long> {

}
