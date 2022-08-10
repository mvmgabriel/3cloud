package br.com.trescon.fmsgateway.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import brave.sampler.Sampler;

@Configuration
public class SleuthConfiguration {
    
	@Bean
	Sampler defaultSampler() {
		return Sampler.ALWAYS_SAMPLE;
	}
    
}
