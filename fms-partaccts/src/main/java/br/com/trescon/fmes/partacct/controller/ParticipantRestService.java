package br.com.trescon.fmes.partacct.controller;


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

import br.com.trescon.fmes.partacct.log.LogFormat;
import br.com.trescon.fmes.partacct.feign.SyncRestClientService;
import brave.Tracer;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/services/participantService")
public class ParticipantRestService {

	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

	@Autowired 
	private Tracer tracer;
	
	@Autowired
    private SyncRestClientService syncRestClientService;
	
	public ParticipantRestService() {
		LOGGER.info(">    >   >  > > ParticipantRestService");
	}
	
	@GetMapping(
        value = "/listParticipantByBVMFCodeRole/{bvmfcode}/{roleId}", 
        consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE, 
        produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> listParticipantByBVMFCodeRole(
        @PathVariable(value = "bvmfcode") String bvmfcode,
        @PathVariable(value = "roleId") int roleId) {

        try {
        	String hostname = System.getenv("HOSTNAME");
        	String text = "bvmfcode: "+ bvmfcode +", roleId: "+ roleId +" ("+hostname+")";
        	
        	tracer.currentSpan().tag("app.text.info.1", text);
        	
        	syncRestClientService.listParticipantByBVMFCodeRole(bvmfcode, roleId);
        	tracer.currentSpan().tag("app.text.info.2", "syncRestClientService after");
    
        	LOGGER.info(LogFormat.print(text,
        			tracer.currentSpan().context().traceIdString(),
        			tracer.currentSpan().context().spanIdString()));
			
        	return ResponseEntity.ok().body(text);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().build();
		}
	}
	
} 