package br.com.trescon.fmsoauth.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.trescon.fmsoauth.entities.UserDomain;

@RestController
@RequestMapping(value = "/auth-teste")
public class AuthController {

	@PostMapping(value = "/login")
	public ResponseEntity<Void> findUserByEmail(UserDomain user) {
		
		return ResponseEntity.ok().build();
	}
}
