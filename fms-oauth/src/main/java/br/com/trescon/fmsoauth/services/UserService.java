package br.com.trescon.fmsoauth.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.trescon.fmsoauth.entities.UserAcm;
import br.com.trescon.fmsoauth.entities.UserDomain;
import br.com.trescon.fmsoauth.entities.UserEntity;
import br.com.trescon.fmsoauth.feignclients.UserFeignClient;
import br.com.trescon.fmsoauth.repositories.UserAcmRepository;
import br.com.trescon.fmsoauth.repositories.UserEntityRepository;

@Service
public class UserService implements UserDetailsService {

	@Autowired
	private UserFeignClient userFeignClient;
	
	@Autowired
	//private UserEntityRepository repo;
	private UserAcmRepository userAcmRepository;
	
	@Override
	public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
		System.out.println("LoadByUsername Testando");
		
		UserAcm user = userAcmRepository.findByLogin(login).orElseThrow(() -> new UsernameNotFoundException(login));
		
		System.out.println(user.getLogin());
		System.out.println(user.getPassword());
		//SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority("ROLE_" + user.getType().name());
		SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority("ROLE_ADMIN");
		return new User(
				user.getLogin(),
				user.getPassword(),
				List.of(simpleGrantedAuthority)
				);
	}
	
	public UserAcm findUserByLogin(String login) throws Exception {
		UserAcm user = userAcmRepository.findByLogin(login).orElseThrow(() -> new UsernameNotFoundException(login));
		return user;
	}
	
	/*
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
	
	*/

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
