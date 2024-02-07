package in.nebulatech.service;

import java.io.FileInputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.nebulatech.entity.Product;
import in.nebulatech.repositoy.ProductRepo;

@Service
public class ProductService {

	@Autowired
	private ProductRepo productRepo;
	
	public ProductService()
	{
		
	}
	public ProductService(ProductRepo productRepo)
	{
		this.productRepo=productRepo;
	}
	
	public void setData()throws Exception
	{
		Product product= new Product();
		product.setProductName("unknown");
		product.setProductPrice(200.00);
		
		String imgpath="D:\\HtmlTutorials\\unknown.jpeg";
		long size=Files.size(Paths.get(imgpath));
		
		
		byte [] arr= new byte[(int)size];
		FileInputStream fis= new FileInputStream(imgpath);
		fis.read(arr);
		fis.close();
		product.setImage(arr);
		
		productRepo.save(product);
	}
	
}
