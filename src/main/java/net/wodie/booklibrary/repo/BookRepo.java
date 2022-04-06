package net.wodie.booklibrary.repo;

import net.wodie.booklibrary.model.Book;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BookRepo {

    Map<String, Book> books = new HashMap<>();

    public Book getBookByIsbn(String isbn) {
        return books.get(isbn);
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
