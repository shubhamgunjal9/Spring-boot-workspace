package in.nebulatech.restControllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import in.nebulatech.bindings.Registration;
import in.nebulatech.repository.RegistrationRepo;

@Controller
public class LoginController {
	
	@Autowired
	private RegistrationRepo registrationRepo;
	

	@GetMapping("/Login")
	public String getLogin(Model model)
	{
		Registration registration=new Registration();
		model.addAttribute("registration", registration);
		return "login";
	}
	
	@PostMapping("/logsuccess")
	public String postLogin(Registration registration,Model model)
	{
		List<Registration> findByEmailAndPassword = registrationRepo.findByEmailAndPassword(registration.getEmail(), registration.getPassword());
		//this.registration=registration;
		if(findByEmailAndPassword.isEmpty()) {
				return "login";
		} else {
			return "logsuccess";
		}
	
	}
	
	
	
}
