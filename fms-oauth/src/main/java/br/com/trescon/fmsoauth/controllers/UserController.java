package br.com.trescon.fmsoauth.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.trescon.fmsoauth.entities.User;
import br.com.trescon.fmsoauth.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserController {
	
	@Autowired
	private UserService service;
	
	@GetMapping(value = "/search")
	public ResponseEntity<User> findUserByEmail(String login) {
		User user = service.findByLogin(login);
		return ResponseEntity.ok(user);
	}

}