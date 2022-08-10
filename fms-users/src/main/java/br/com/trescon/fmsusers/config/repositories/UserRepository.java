package br.com.trescon.fmsusers.config.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.trescon.fmsusers.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

	public User findByLogin(String login);
}