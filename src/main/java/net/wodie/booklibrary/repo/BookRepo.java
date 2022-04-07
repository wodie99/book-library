package net.wodie.booklibrary.repo;

import net.wodie.booklibrary.model.Book;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class BookRepo {

    Map<String, Book> books = new HashMap<>();

    public Optional<Book> getBookByIsbn(String isbn) {
        Optional<Book> optionalBook = Optional.ofNullable(books.get(isbn));
        return optionalBook;

    }

    public Book addBook(Book book) {
        books.put(book.getIsbn(), book);
        return book;
    }

    public Book delBookByIsbn(String isbn) {
        Book delBook = books.get(isbn);
        books.remove(isbn);
        return delBook;
    }

    public List<Book> getAllBooks() {
        List<Book> booksArrayList = new ArrayList<>();
        for (String key: this.books.keySet())  {
            booksArrayList.add(books.get(key));
        }
        return booksArrayList;
    }
}
