package br.com.trescon.fmsoauth.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.trescon.fmsoauth.entities.User;
import br.com.trescon.fmsoauth.feignclients.UserFeignClient;

@Service
public class UserService {

	@Autowired
	private UserFeignClient userFeignClient;
	
	public User findByLogin(String login) {
		User user = userFeignClient.findByLogin(login).getBody();
		return user;
	}
}
