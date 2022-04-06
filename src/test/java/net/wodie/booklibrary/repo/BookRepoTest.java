package net.wodie.booklibrary.repo;

import net.wodie.booklibrary.model.Book;
import net.wodie.booklibrary.services.BookService;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class BookRepoTest {

    BookRepo repo = new BookRepo();

    Book testBook1 = new Book("11111","Testbuch", "T. Tester");
    Book testBook2 = new Book("22222","Testbuch2", "T. Tester");
    List<Book> testList1 = Arrays.asList(testBook1,testBook2);
    Map<String, Book> books1 = new HashMap<>();





    @Test
    void addBook_TestReturn() {
        //GIVEN

        //WHEN

        Book actual = repo.addBook(testBook1);

        //THEN
        Book expected = testBook1;
        assertEquals(expected, actual);
    }


    @Test
    void getAllBooks() {
        //GIVEN
        repo.addBook(testBook1);
        repo.addBook(testBook2);

        //WHEN
        List<Book> actual = repo.getAllBooks();

        //THEN
        assertEquals(testList1, actual);
    }
}