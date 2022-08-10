package br.com.trescon.instruments.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.trescon.instruments.entities.Instrument;
import br.com.trescon.instruments.repositories.InstrumentRepository;

@Service
public class InstrumentService {

	@Autowired
	private InstrumentRepository repo;
	
	public Instrument findById(Long id) {
		return repo.findById(id).get();
	}
}
