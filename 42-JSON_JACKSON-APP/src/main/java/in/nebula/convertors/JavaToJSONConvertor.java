package in.nebula.convertors;

import java.io.File;

import com.fasterxml.jackson.databind.ObjectMapper;

import in.nebula.bindings.Book;

public class JavaToJSONConvertor {

	public static void main(String[] args) throws Exception {
		
		Book book = new Book(101,"spring",1999.99);
		
		ObjectMapper mapper = new ObjectMapper();
		
		mapper.writeValue(new File("Book.json"), book);
		
		System.out.println("object creation successfull....!");
	}
}
