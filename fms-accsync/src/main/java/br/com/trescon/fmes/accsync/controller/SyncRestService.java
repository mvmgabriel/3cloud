package br.com.trescon.fmes.accsync.controller;

import static br.com.trescon.fmes.accsync.exception.ExceptionUtilities.extractPrintStackTrace;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import brave.Tracer;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/services/syncService")
public class SyncRestService {

	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

	@Autowired 
	private Tracer tracer;
	
	public SyncRestService() {
		LOGGER.info(">    >   >  > > SyncRestService");
	}
	
	@GetMapping(
        value = "/getParticipant/{bvmfcode}/{roleId}", 
        consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE, 
        produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> listParticipantByBVMFCodeRole(
        @PathVariable(value = "bvmfcode") String bvmfcode,
        @PathVariable(value = "roleId") int roleId) {

		try {
        	String hostname = System.getenv("HOSTNAME");
        	String text = "sync ==>>> bvmfcode: "+ bvmfcode +", roleId: "+ roleId +" ("+hostname+")";
        	
        	if(System.currentTimeMillis()%4 == 0)
        		throw new Exception("Erro forçado para testes do zipkin...");
        	
        	//LOGGER.info(text);
			return ResponseEntity.ok().body(text);
		} catch (Exception e) {
			tracer.currentSpan().tag("app.error.stackTrace", extractPrintStackTrace(e));
			return ResponseEntity.badRequest().build();
		}
	}
	
} 