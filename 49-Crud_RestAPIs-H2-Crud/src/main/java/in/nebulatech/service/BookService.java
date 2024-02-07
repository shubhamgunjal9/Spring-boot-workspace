package in.nebulatech.service;

import java.util.List;

import org.springframework.stereotype.Service;

import in.nebulatech.entity.Book;


public interface BookService {
	
	public List<Book> getAllBooks();
	//public String updateBook(Book book);
	public String deleteBook(Integer bookId);
	public String upsertBook(Book book);

}
