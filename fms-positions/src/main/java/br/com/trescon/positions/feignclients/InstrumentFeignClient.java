package br.com.trescon.positions.feignclients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.trescon.positions.config.OAuthFeignConfig;
import br.com.trescon.positions.entities.Instrument;


@Component
@FeignClient(name = "fms-instruments", path = "/instruments", configuration = OAuthFeignConfig.class)
public interface InstrumentFeignClient {
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Instrument> findById(@PathVariable("id") Long id);
	
	@GetMapping(value = "/symbol/{symbol}")
	public ResponseEntity<Instrument> findBySymbol(@PathVariable("symbol") String symbol);

}
