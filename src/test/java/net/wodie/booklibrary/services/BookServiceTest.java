package net.wodie.booklibrary.services;

import net.wodie.booklibrary.model.Book;
import net.wodie.booklibrary.repo.BookRepo;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class BookServiceTest {

    BookRepo repo = mock(BookRepo.class);
    BookService service = new BookService(repo);

    Book testBook1 = new Book("11111","Testbuch", "T. Tester");
    Book testBook2 = new Book("22222","Testbuch2", "T. Tester");
    List<Book> testList1 = Arrays.asList(testBook1,testBook2);

    @Test
    void getAllBooks() {
        //GIVEN
        when(repo.getAllBooks()).thenReturn(testList1);

        //WHEN
        List<Book> actual = service.getAllBooks();
        verify(repo).getAllBooks();

        //Then
        assertEquals(testList1, actual);
    }

    @Test
    void getBookByIsbn() {
        //GIVEN
        when(repo.getBookByIsbn("11111")).thenReturn(testBook1);

        //WHEN
        Book actual = service.getBookByIsbn("11111");
        verify(repo).getBookByIsbn("11111");

        //THEN
        assertEquals(testBook1, actual);
    }
}

