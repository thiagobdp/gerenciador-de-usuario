package br.com.pollingmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.pollingmanager.model.Payload;

public interface PayloadRepository extends JpaRepository<Payload, Long> {

}
