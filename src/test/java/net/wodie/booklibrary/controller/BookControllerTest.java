package net.wodie.booklibrary.controller;

import net.wodie.booklibrary.model.Book;
import net.wodie.booklibrary.repo.BookRepo;
import net.wodie.booklibrary.services.BookService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class BookControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private WebTestClient testClient;

    @Autowired
    private BookRepo bookRepo;


    Book testBook1 = new Book("11111", "Testbuch", "T. Tester");
    Book testBook2 = new Book("22222", "Testbuch2", "T. Tester");
    List<Book> testList1 = Arrays.asList(testBook1, testBook2);




    @Test
    void getAllBooks() {
        //GIVEN
        Book book1 = new Book("11111", "Abendrot", "A. Anders");
        bookRepo.addBook(book1);

        //WHEN
        List<Book> actual = testClient.get()
                .uri("http://localhost:"+port+"/book/all")
                .exchange()
                .expectStatus().is2xxSuccessful()
                .expectBodyList(Book.class)
                .returnResult()
                .getResponseBody();

        //THEN
        List<Book> expected = List.of(new Book("11111", "Abendrot", "A. Anders"));
        assertEquals(expected, actual);
    }


}