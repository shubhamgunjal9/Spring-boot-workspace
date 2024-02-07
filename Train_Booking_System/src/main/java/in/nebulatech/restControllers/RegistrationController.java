package in.nebulatech.restControllers;

import javax.validation.constraints.Email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import in.nebulatech.bindings.Mail;
import in.nebulatech.bindings.Registration;
import in.nebulatech.repository.RegistrationRepo;
import in.nebulatech.service.EmailSenderService;


@Controller
public class RegistrationController {

	@Autowired
	private RegistrationRepo registrationRepo;
	
	@Autowired
	private EmailSenderService senderService;

//	@Autowired
//	private MailSender mailSender;

	private Registration registration;

	@GetMapping("/register")
	public String getRegisterData(Model model) {
		Registration registration = new Registration();
		model.addAttribute("registration", registration);
		return "registration";
	}

	@PostMapping("/regsuccess")
	public String setRegisterData(Registration registration, Model model) {
		System.out.println(registration);
		registrationRepo.save(registration);
		this.registration = registration;
		senderService.sendMail(registration.getEmail(),
				"Registration Successfull to our Website",
				"book your train with irctc\n ->login and book your train");
		// registrationController.sendMail();
		return "regsuccess";
	}
	  

	@GetMapping("/regsuccess")
	public String setRegSuccess() {

		
		System.out.println("reg success");
		return "regsuccess";
	}
	
	

	
}
