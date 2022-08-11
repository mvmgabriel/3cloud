package br.com.trescon.fmes.accsync;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import brave.sampler.Sampler;

@Configuration
public class SleuthConfiguration {
    
	@Bean
	public Sampler defaultSampler() {
		return Sampler.ALWAYS_SAMPLE;
	}
    
}
