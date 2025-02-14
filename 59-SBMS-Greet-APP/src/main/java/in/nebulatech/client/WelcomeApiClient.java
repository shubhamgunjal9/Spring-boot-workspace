package in.nebulatech.client;

import javax.ws.rs.GET;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name="WELCOME-API")
public interface WelcomeApiClient {
	
	@GetMapping("/")
	public String involkeWelcomeMsg();
	

}
