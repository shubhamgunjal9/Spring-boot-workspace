package in.nebulatech.reporistory;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import in.nebulatech.entity.Book;
import in.nebulatech.service.BookService;


@RestController
public class BookRestController {

	@Autowired
	private BookService bookService;
	@GetMapping("/book  ")
	public ResponseEntity<List<Book>> getAllBook() {
		List<Book> list=bookService.getAllBooks();
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
	
	@PostMapping("/book")
	public ResponseEntity<String> saveBooks(@RequestBody Book book){
		String status=bookService.upsertBook(book);
		return new ResponseEntity<>(status,HttpStatus.CREATED);
	}
	@PutMapping("/book")
	public ResponseEntity<String> updateBook(@RequestBody Book book) {
		String status=bookService.upsertBook(book);
		return new ResponseEntity<>(status,HttpStatus.OK);
	}
	
	@DeleteMapping("/book/{bookId}")
	public ResponseEntity<String> deleteBooks(@RequestParam Integer bookId) {
		String status=bookService.deleteBook(bookId);
		return new ResponseEntity<>(status,HttpStatus.OK);
	}
}
