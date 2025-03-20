package com.prasidyo;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;

public class AppConfig {

    @Bean
    public Author author1() {
        Author author = new Author();
        author.setId(1L);
        author.setName("Author 1");
        return author;
    }

    @Bean
    public Book book1(@Qualifier("author1") Author author) {
        Book book = new Book();
        book.setTitle("Book 1");
        book.setAuthor(author);
        return book;
    }
}
