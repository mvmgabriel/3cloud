package br.com.trescon.instruments.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.trescon.instruments.entities.Instrument;
import br.com.trescon.instruments.services.InstrumentService;

@RestController
@RequestMapping(value = "/instruments")
public class InstrumentController {
	
	@Autowired
	private InstrumentService service;
	
	@Autowired
	private Environment env;

	@GetMapping(value = "/{id}")
	public ResponseEntity<Instrument> findById(@PathVariable("id") Long id) {
		String port = env.getProperty("local.server.port");
		System.out.println("*** PORTA GET: " + port);
		
		Instrument obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
		
	}

}
