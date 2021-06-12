package br.com.gerenciador.assembleias.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.gerenciador.assembleias.model.UserAccreditation;

public interface UserAccreditationRepository extends JpaRepository<UserAccreditation, Long> {

	UserAccreditation findByUserId(String userId);

}
