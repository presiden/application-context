package com.prasidyo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        // ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        
        Author author = (Author) context.getBean("author1");
        System.out.println("Author ID: " + author.getId());
        System.out.println("Author Name: " + author.getName());
        
        Book book = (Book) context.getBean("book1");
        System.out.println("Book Title: " + book.getTitle());
        System.out.println("Author Name: " + book.getAuthor().getName());

        EmailService emailService = (EmailService) context.getBean("emailService");
        try {
            emailService.sendMail();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}