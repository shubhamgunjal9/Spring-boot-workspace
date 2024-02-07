package in.nebulatech.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import in.nebulatech.client.WelcomeApiClient;

@RestController
public class GreetRestController {
	
	@Autowired
	private WelcomeApiClient apiClient;
	@GetMapping("/greet")
	public String getGreetMsg() {
		String msg=apiClient.involkeWelcomeMsg();
		return "good morning Shubham ..!!" +msg;
	}

}
