package net.wodie.booklibrary.services;

import net.wodie.booklibrary.api.IsbnApi;
import net.wodie.booklibrary.model.ApiBook;
import net.wodie.booklibrary.model.Book;
import net.wodie.booklibrary.repo.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

//    BookRepo repo = new BookRepo();
    private final BookRepo repo;
    private final IsbnApi isbnApi;

    @Autowired
    public BookService(BookRepo repo, IsbnApi isbnApi) {
        this.repo = repo;
        this.isbnApi = isbnApi;
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

    public Book addBookByIsbn(String isbn) {
        Book newBook = isbnApi.getBookByIsbn(isbn);
        return repo.addBook(newBook);
    }
}
