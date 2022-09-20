package com.example.demospringboot.service;

import com.example.demospringboot.entity.Book;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BookService {
    List<Book> getAllBooks();
    Book getBookById(int id);
    void deleteBookById(int id);
    List<Book> deleteBookById1(int id);
    List<Book> createBook(Book book);
    Book updateBook(int id, Book bookName);
}
