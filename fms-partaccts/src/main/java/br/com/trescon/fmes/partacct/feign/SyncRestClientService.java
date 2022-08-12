package br.com.trescon.fmes.partacct.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(url = "http://gateway-server:9000", path = "/fms-accsync/services/syncService",
	name = "fms-accsync")
public interface SyncRestClientService {

	@GetMapping(value = "/getParticipant/{bvmfcode}/{roleId}", 
        consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE, 
        produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> listParticipantByBVMFCodeRole(
        @PathVariable(value = "bvmfcode") String bvmfcode,
        @PathVariable(value = "roleId") int roleId);
}
