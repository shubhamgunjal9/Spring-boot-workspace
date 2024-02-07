package in.nebula.convertors;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

import in.nebula.bindings.Book;

public class JSONToJavaConvertor {
	
	public static void main(String[] args) throws Exception {
		
		ObjectMapper mapper = new ObjectMapper();
		
		Book readValue = mapper.readValue(new File("Book.json"),Book.class);
		
		System.out.println(readValue);
		
		
	}

}
