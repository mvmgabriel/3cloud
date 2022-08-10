package br.com.trescon.positions.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.trescon.positions.dto.PositionSimpleDto;
import br.com.trescon.positions.services.PositionService;
import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;

@RestController
@RequestMapping(value = "/positions")
public class PositionController {

	
	@Autowired
	private PositionService service;

	@GetMapping(value = "/{securitiesFinancingTradeId}")
	@Retry(name = "default" , fallbackMethod= "fallbackMethod")
	public ResponseEntity<PositionSimpleDto> findById(@PathVariable("securitiesFinancingTradeId") String id) throws Exception {
		PositionSimpleDto obj = service.findById(id, 2);
		return ResponseEntity.ok().body(obj);
	}
	
	@GetMapping(value = "/error/{securitiesFinancingTradeId}")
	//@Retry(name = "default" , fallbackMethod= "fallbackMethod") //ELE TENTA TODOS RETRYS ANTES DEPOIS CHAMA FALLBACK
	//@CircuitBreaker(name = "default", fallbackMethod = "fallbackMethod")
	//@RateLimiter(name = "default")
	@Bulkhead(name = "default")
	public ResponseEntity<PositionSimpleDto> findByIdWithError(@PathVariable("securitiesFinancingTradeId") String id) throws Exception {
		PositionSimpleDto obj = service.findByIdError(id, 2);
		return ResponseEntity.ok().body(obj);
	}
	
	public ResponseEntity<PositionSimpleDto> fallbackMethod(Exception ex) {
		return ResponseEntity.ok().body(null);
	}
	
}