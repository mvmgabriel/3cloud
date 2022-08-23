package br.com.trescon.fmsoauth.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.trescon.fmsoauth.entities.UserEntity;

//@Repository
public interface UserEntityRepository {

	public UserEntity findByEmail(String email);
}