package br.com.trescon.fmsoauth.feignclients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.trescon.fmsoauth.entities.UserDomain;

@Component
@FeignClient(name = "fms-users", path="/users")
public interface UserFeignClient {

	@GetMapping(value = "/search")
	public ResponseEntity<UserDomain> findByLogin(@RequestParam String login);
	
	@GetMapping(value = "/search")
	public ResponseEntity<UserDomain> findByEmail(@RequestParam String email);
}
