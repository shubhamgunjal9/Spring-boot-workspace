package in.nebulatech.restControllers;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import in.nebulatech.bindings.Booking;
import in.nebulatech.qrgenertor.QrGenerator;
import in.nebulatech.repository.TickitBookRepo;
import in.nebulatech.service.EmailSenderService;

@Controller
public class TrainBookingRest {

	@Autowired
	private TickitBookRepo bookRepo;
	private Booking booking;
	
	@Autowired
	private EmailSenderService senderService;


	@GetMapping("/BookTicket")
	public String trainBooking(Model model) {
		Booking booking = new Booking();
		model.addAttribute("booking", booking);
		return "BookTicket";
	}

	@PostMapping("/BookTicket")
	public String success(Booking booking, Model model) throws Exception {
		
		System.out.println(booking);
		bookRepo.save(booking);
		QrGenerator.generateQRcode(booking);
		this.booking = booking;
		System.out.println("booking successfull");
		return "success";

	}

	@GetMapping("/success")
	public String successPage(Model model) {
		model.addAttribute("booking", booking);
		return "success";
	}

	@GetMapping("/send")
	public String sendTicket(Model model) throws MessagingException {
		model.addAttribute("booking", booking);
		String path="C:\\Users\\Shree\\Documents\\workspace-spring-tool-suite-4-4.15.3.RELEASE\\Train_Booking_System\\src\\main\\webapp\\qrcodes\\";
		String QRcodename=path+booking.getEmail()+"QRCODE.png";
		senderService.sendMailAttach(booking.getEmail(), "PLEASE TAKE YOUR TICKET", 
				"thank you for visiting irctc officials", QRcodename);
		return "success";
	}

	
	
}
