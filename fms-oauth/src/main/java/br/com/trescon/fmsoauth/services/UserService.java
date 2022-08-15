package br.com.trescon.fmsoauth.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.trescon.fmsoauth.entities.UserDomain;
import br.com.trescon.fmsoauth.entities.UserEntity;
import br.com.trescon.fmsoauth.feignclients.UserFeignClient;
import br.com.trescon.fmsoauth.repositories.UserEntityRepository;

@Service
public class UserService implements UserDetailsService {

	@Autowired
	private UserFeignClient userFeignClient;
	
	@Autowired
	private UserEntityRepository repo;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		UserEntity user = repo.findByEmail(email);
		
		if(user == null) {
			throw new UsernameNotFoundException(email);
		}
		
		SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority("ROLE_" + user.getType().name());
		return new User(
				user.getEmail(),
				user.getPassword(),
				List.of(simpleGrantedAuthority)
				);
	}
	
	public UserEntity findUserByEmail(String email) throws Exception {
		UserEntity user = repo.findByEmail(email);
		if(user == null) {
			throw new Exception("Usuário não encontrado: " + email); //notfound
		}
		return user;
	}

	/*
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		UserDomain user = userFeignClient.findByEmail(email).getBody();
		
		if(user == null) {
			throw new UsernameNotFoundException(email);
		}
		
		SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority("ROLE_" + user.getType().name());
		return new User(
				user.getEmail(),
				user.getPassword(),
				List.of(simpleGrantedAuthority)
				);
	}
	
	public UserDomain findUserByEmail(String email) throws Exception {
		UserDomain user = userFeignClient.findByEmail(email).getBody();
		if(user == null) {
			throw new Exception("Usuário não encontrado: " + email); //notfound
		}
		return user;
	}
	*/
}
