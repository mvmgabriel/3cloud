package br.com.trescon.fmsoauth.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.trescon.fmsoauth.entities.UserAcm;

@Repository
public interface UserAcmRepository extends JpaRepository<UserAcm, Integer>{

	Optional<UserAcm> findByLogin(String login);
}