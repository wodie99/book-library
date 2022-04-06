package net.wodie.booklibrary.controller;

import net.wodie.booklibrary.model.ApiBook;
import net.wodie.booklibrary.model.Book;
import net.wodie.booklibrary.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("book")
public class BookController {

    private final BookService service;

    @Autowired
    public BookController(BookService service) {
        this.service = service;
    }


    @RequestMapping("/all")
    public List<Book> getAllBooks() {
        return service.getAllBooks();
    }

    @GetMapping(path = "{isbn}")
    public Book getBookByIsbn(@PathVariable String isbn) {
        return service.getBookByIsbn(isbn);
    }

    @PostMapping
    public Book addBook(@RequestBody Book book) {
        return service.addBook(book);
    }

    @DeleteMapping("{isbn}")
    public Book delBookByIsbn(@PathVariable String isbn) {
        return service.delBookByIsbn(isbn);
    }

    @PutMapping("/api/{isbn}")
    public Book addBookByIsbn(@PathVariable String isbn) {
        return service.addBookByIsbn(isbn);
    }



}
