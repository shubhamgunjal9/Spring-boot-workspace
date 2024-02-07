package in.nebulatech.restapi;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {
	
	@GetMapping("/")
	public ResponseEntity<String> getWelcomeMsg(@RequestParam("name") String name,@RequestParam("id") Integer id)
	{
		String resPayload = name+" , welcome to ashok it....."+id;
		return new ResponseEntity<>(resPayload,HttpStatus.OK);
	}
	@GetMapping("/greet")
	public String getGreetMsg()
	{
		String resPayload= "good morning";
		return resPayload;
	}

}
