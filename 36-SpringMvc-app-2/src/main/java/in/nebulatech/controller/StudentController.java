package in.nebulatech.controller;

import java.util.*;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import in.nebulatech.entity.Student;

@Controller
public class StudentController {
	
	
	@GetMapping("/")
	public ModelAndView getHome()
	{
		ModelAndView view=new ModelAndView();
		view.addObject("hello","hello home page");
		view.setViewName("home");
		return view;
	}
	
	@GetMapping("/login")
	public String getLogin(Model model)
	{
		model.addAttribute("log", "hello login page");
		return "login";
	}  

	@GetMapping("/index")
	public String getIndex(Model model)
	{
		List<Student> list = new ArrayList<Student>();
		Student student1 =new Student(101,"shubham",8208090110l);
		Student student2 =new Student(102,"Jayesh",9049754332l);
		Student student3 =new Student(103,"rameshwar",9860501254l);
		Student student4 =new Student(104,"prashant",9022435878l);
		list.addAll(Arrays.asList(student1,student2,student3,student4));
		model.addAttribute("student", list);
		return "index";
	}
	
	
	

}
