package net.wodie.booklibrary.services;

import net.wodie.booklibrary.model.Book;
import net.wodie.booklibrary.repo.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

//    BookRepo repo = new BookRepo();
    private final BookRepo repo;

    @Autowired
    public BookService(BookRepo repo) {
        this.repo = repo;
    }



    public List<Book> getAllBooks() {
        return repo.getAllBooks();
    }

    public Book getBookByIsbn(String isbn) {
        return repo.getBookByIsbn(isbn);
    }

    public Book addBook(Book book) {
        return repo.addBook(book);
    }

    public Book delBookByIsbn(String isbn) {
        return repo.delBookByIsbn(isbn);
    }
}
