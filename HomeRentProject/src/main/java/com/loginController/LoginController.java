package com.loginController;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {
	@RequestMapping(value="LoginPage")
	public String LoginPage(){
		System.out.println("LogIN Page...");
		return "LoginPageView";
	}
	
	@RequestMapping(value="HomePage")
	public String HomePage(Model model,HttpServletRequest request){
		System.out.println("Home Page...");
		
		String user = request.getParameter("userName");
		System.out.println("user: " + user);
	
		String pwd = request.getParameter("password");
		System.out.println("pwd: " + pwd);
 		
		if(user.equals("Dhananjay Jadhav44") && pwd.equals("Dj291181")){
			System.out.println("UserName is : " +   user  + "Password is : " +pwd);
			return "Home";
			//return "HomePageView";
		}else{
			model.addAttribute("Message", "Please Enter Correct UserName And Password");
			return "LoginPageView";
		}
	}
	
	@RequestMapping("HomePageNew")
	public ModelAndView HomePageNew()
	{
		System.out.println("Second Home Page");
	 return new ModelAndView ("HomePageView");
	}
	
	@RequestMapping("HomePagee")
	public ModelAndView HomePage()
	{
	 return new ModelAndView ("HomePageView");
		
	}
	@RequestMapping("LogoutPage")
	public ModelAndView LogoutPage()
	{
		System.out.println("Logout Page");
		return new ModelAndView("LogoutPageView");
	}


}
