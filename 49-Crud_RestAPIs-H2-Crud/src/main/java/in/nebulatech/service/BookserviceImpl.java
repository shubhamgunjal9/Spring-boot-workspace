package in.nebulatech.service;

import java.util.List;

import org.springframework.stereotype.Service;

import in.nebulatech.entity.Book;
import in.nebulatech.repository.BookRepository;

@Service
public class BookserviceImpl implements BookService {

	private BookRepository bookRepository;

	public BookserviceImpl(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}

	@Override
	public List<Book> getAllBooks() {
		return bookRepository.findAll();
	}

	@Override
	public String deleteBook(Integer bookId) {
		bookRepository.deleteById(bookId);
		return "successfully deleted";
	}

	@Override
	public String upsertBook(Book book) {
		bookRepository.save(book);
		if (book.getBookId() == null) {
			return "updated";
		} else {
			return "inserted";
		}
	}
}
