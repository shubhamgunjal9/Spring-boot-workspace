package in.nebulatech.restapi;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CourceController {
	@GetMapping("/cource")
	public ResponseEntity<String> getCourceDetails(@RequestParam("tname") String tname,@RequestParam("cname")String cname)
	{
		String resPayload=cname+" trainer is "+tname+" cource fees is 70000";
		
		return new ResponseEntity<>(resPayload,HttpStatus.OK);
	}

}
