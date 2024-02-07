package in.nebulatech.restapi;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookRestController {
	
	@GetMapping("/book/{name}")
	public ResponseEntity<String> getBookDetail(@PathVariable("name") String name)
	{
		String resPayload = "book name is "+name;
		
		return new ResponseEntity<>(resPayload,HttpStatus.OK);
		
	}
	
	@GetMapping("/author/{bname}/{aname}")
	public ResponseEntity<String> getBookAuthor(@PathVariable("bname") String bname,@PathVariable("aname") String aname)
	{
		String resPayload = bname+" by "+aname + " is not avilable";
		
		return new ResponseEntity<>(resPayload,HttpStatus.OK);
	}
	

}
