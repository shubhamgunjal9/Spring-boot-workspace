package in.nebulatech.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import in.nebulatech.entity.Product;

@Controller
public class ProductController {
	
	@GetMapping("/")
	public String setproductDetails(Model model)
	{
		Product product= new Product();
		model.addAttribute("product", product);
		return "home";
	}
	
	@PostMapping("/product")
	public String getproductDetails(Model model,Product product)
	{
		System.out.println(product);
		model.addAttribute("msg", "product saved successfull....");
		return "success";
	}
	
	

}
