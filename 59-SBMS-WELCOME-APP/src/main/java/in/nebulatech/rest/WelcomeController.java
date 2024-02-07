package in.nebulatech.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {
	
	@GetMapping("/")
	public String getMsg() {
		String msg="hello goood morning";
		return msg;
	}

}
