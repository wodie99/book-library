package net.wodie.booklibrary.model;


import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Book {
    private final String isbn;
    private String title;
    private String author;
}
