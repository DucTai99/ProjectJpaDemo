package com.example.demospringboot.service.impl;

import com.example.demospringboot.entity.Book;
import com.example.demospringboot.respository.BookRespository;
import com.example.demospringboot.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookRespository bookRespository;

    @Override
    public List<Book> getAllBooks() {
        return bookRespository.findAll();
    }

    @Override
    public Book getBookById(int id) {
        return bookRespository.findById(id).stream().findFirst().orElse(null);
    }

    @Override
    @Transactional
    public void deleteBookById(int id) {
         bookRespository.deleteBookByBookId(id);
    }

    @Override
    public List<Book> deleteBookById1(int id) {
        return null;
    }

    @Override
    public List<Book> createBook(Book book) {
        bookRespository.save(book) ;
        List<Book> bookList = bookRespository.findAll();
        return bookList;
    }
    @Override
    public Book updateBook(int id, Book bookName) {
        Book book = bookRespository.findById(id).stream().findFirst().orElse(null);
        if (book != null){
            book.setBookName(bookName.getBookName());
            bookRespository.save(book);
        }
        return book;
    }

}
