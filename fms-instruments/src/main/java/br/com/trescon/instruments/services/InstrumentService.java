package br.com.trescon.instruments.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import br.com.trescon.instruments.entities.Instrument;
import br.com.trescon.instruments.repositories.InstrumentRepository;
import br.com.trescon.instruments.services.exceptions.ObjectNotFoundException;

@Service
public class InstrumentService {

	@Autowired
	private InstrumentRepository repo;
	
	@Cacheable(value = "instruments")
	public Instrument findById(Long id) {
		return repo.findById(id).orElseThrow(() -> new ObjectNotFoundException("Instrumento não encontrado."));
	}
}
