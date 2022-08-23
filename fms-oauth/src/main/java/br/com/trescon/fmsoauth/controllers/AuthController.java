package br.com.trescon.fmsoauth.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.trescon.fmsoauth.dto.CredentialsDto;
import br.com.trescon.fmsoauth.entities.UserAcm;
import br.com.trescon.fmsoauth.security.JWTUtil;
import br.com.trescon.fmsoauth.services.UserService;

@RestController
@RequestMapping(value = "/auth")
public class AuthController {

	@Autowired
	private AuthenticationManager authentication;
	
	@Autowired
	private JWTUtil jwtUtil;
	
	@Autowired
	private UserService userService;
	
	//@PreAuthorize("hasRole('ROLE_TESTE')")
	
	@PostMapping(value = "/login")
	public ResponseEntity<String> findUserByEmail(@RequestBody CredentialsDto credentials) throws Exception {
		Authentication auth;
		
		try {
			auth = authentication.authenticate(new UsernamePasswordAuthenticationToken(credentials.getLogin(), credentials.getPassword()));
			SecurityContextHolder.getContext().setAuthentication(auth);
		} catch (BadCredentialsException e) {
			//throw new Exception("Credentials Invalid");
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
		}
		
		UserAcm user = userService.findUserByLogin(credentials.getLogin());
		String token = jwtUtil.generateToken(user);
		//System.out.println("TOKEN");
		//System.out.println(generateToken());
		return ResponseEntity.ok(token);
		//return ResponseEntity.ok("");
	}
	

}
