package br.com.trescon.fmsusers.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.trescon.fmsusers.config.repositories.UserRepository;
import br.com.trescon.fmsusers.entities.User;

@Service
public class UserService {

	@Autowired
	private UserRepository repo;
	
	public User findById(Long id) {
		return repo.findById(id).get();
	}

	public User findByEmail(String email) {
		return repo.findByEmail(email);
	}
	
}
