package net.wodie.booklibrary.api;

import net.wodie.booklibrary.model.ApiBook;
import net.wodie.booklibrary.model.Book;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class IsbnApi {

    WebClient webClient = WebClient.create("https://my-json-server.typicode.com/Flooooooooooorian/BookApi/books");
//    WebClient webClient = WebClient.create();

    public Book getBookByIsbn(String id) {
        ApiBook apiBook = webClient
                .get()
                .uri("/"+id)
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .retrieve()

                .toEntity(ApiBook.class)
                .block()
                .getBody();

        Book book = new Book (apiBook.getId(),apiBook.getTitle(), apiBook.getAuthor());

        return book;
    }
}
