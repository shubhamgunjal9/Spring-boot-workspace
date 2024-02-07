package in.nebulatech.rest;

import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.nebulatech.entity.User;

@RestController
public class RedisController {
	public HashOperations<String, Integer, User> hashOps;
	public RedisController(RedisTemplate<String, User> template) {
		hashOps=template.opsForHash();		
	}
	
	@PostMapping("/store")
	public String storeData(@RequestBody User user) {
		hashOps.put("USER", user.getUserId(), user);
		return "success";
	}
	
	@GetMapping("/data/{id}")
	public User getData(@PathVariable int id) {
		User value= (User) hashOps.get("USER",id);
		return value;
	}
}
