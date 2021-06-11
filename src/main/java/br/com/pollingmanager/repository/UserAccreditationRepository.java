package br.com.pollingmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.pollingmanager.model.UserAccreditation;

public interface UserAccreditationRepository extends JpaRepository<UserAccreditation, Long> {

	UserAccreditation findByUserId(String userId);

}
