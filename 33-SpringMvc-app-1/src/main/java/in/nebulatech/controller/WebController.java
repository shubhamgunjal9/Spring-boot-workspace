package in.nebulatech.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WebController {
	
	@GetMapping("/")
	public ModelAndView getWelcomePage()
	{
		ModelAndView mav=new ModelAndView();
		mav.addObject("msg", "welcome to nebula technology.....!!");
		mav.setViewName("index");
		return mav;
	}
	
	@GetMapping("/login")
	public ModelAndView getLoginPage()
	{
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("login");
		
		return mav;
	}
	
}
