package br.com.useraccreditation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.useraccreditation.model.UserAccreditation;

public interface UserAccreditationRepository extends JpaRepository<UserAccreditation, Long> {

	UserAccreditation findByUserId(String userId);

}
