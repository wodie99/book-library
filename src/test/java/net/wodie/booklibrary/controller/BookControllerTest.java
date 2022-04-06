package net.wodie.booklibrary.controller;

import net.wodie.booklibrary.model.Book;
import net.wodie.booklibrary.repo.BookRepo;
import net.wodie.booklibrary.services.BookService;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class BookControllerTest {
    BookService service = mock(BookService.class);
    BookController controller = new BookController(service);


    Book testBook1 = new Book("11111","Testbuch", "T. Tester");
    Book testBook2 = new Book("22222","Testbuch2", "T. Tester");
    List<Book> testList1 = Arrays.asList(testBook1,testBook2);



    @Test
    void getAllBooks() {
        //GIVEN
        when(service.getAllBooks()).thenReturn(testList1);

        //WHEN
        List<Book> actual = controller.getAllBooks();
        verify(service).getAllBooks();

        //Then
        assertEquals(testList1, actual);
    }

    @Test
    void getBookByIsbn() {
        //GIVEN
        when(service.getBookByIsbn("11111")).thenReturn(testBook1);

        //WHEN
        Book actual = controller.getBookByIsbn("11111");
        verify(service).getBookByIsbn("11111");

        //THEN
        assertEquals(testBook1, actual);
    }
}