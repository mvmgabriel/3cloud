package br.com.trescon.positions.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.trescon.positions.dto.PositionSimpleDto;
import br.com.trescon.positions.entities.Instrument;
import br.com.trescon.positions.entities.Position;
import br.com.trescon.positions.entities.PositionId;
import br.com.trescon.positions.feignclients.InstrumentFeignClient;
import br.com.trescon.positions.repositories.PositionRepository;

@Service
public class PositionService {
	
	@Autowired
	private PositionRepository repo;
	
	@Autowired
	private InstrumentFeignClient instrumentFeignClient;
	
	public PositionSimpleDto findById(String securitiesFinancingTradeId, Integer side) {
		Position position = repo.findById(new PositionId(securitiesFinancingTradeId, side)).get();
		Instrument instrument = instrumentFeignClient.findById(position.getInstrumentId()).getBody();
		return new PositionSimpleDto(position, instrument);
	}
	
	public PositionSimpleDto findByIdError(String securitiesFinancingTradeId, Integer side) {
		Position position = repo.findById(new PositionId(securitiesFinancingTradeId, side)).get();
		Instrument instrument = instrumentFeignClient.findBySymbol("Teste").getBody();
		return new PositionSimpleDto(position, instrument);
	}

}
