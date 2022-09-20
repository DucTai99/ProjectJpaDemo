package com.example.demospringboot.controller;

import com.example.demospringboot.dto.BookDTO;
import com.example.demospringboot.entity.Book;
import com.example.demospringboot.service.BookService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {
    @Autowired
    private BookService bookService;
    @Autowired
    private ModelMapper modelMapper;

    @GetMapping("/books")
    public ResponseEntity<?> getAllBooks() {
        List<Book> books = bookService.getAllBooks();
        books.forEach(ele -> System.out.println(ele));
        return ResponseEntity.ok(books);
    }

    @GetMapping("/books/{id}")
    public ResponseEntity<?> getBookById(@PathVariable int id) {
        Book book = bookService.getBookById(id);
        //-- gán dto vào entity và get ra (cach code thuan)
        //        BookDTO dto = new BookDTO();
        //        dto.setBookId(book.getBookId());
        if (book != null) {
            BookDTO bookDTO = modelMapper.map(book, BookDTO.class);
            return ResponseEntity.ok(bookDTO);
        } else {
            return ResponseEntity.notFound().build();
        }

    }

    @DeleteMapping("/books/{id}")
    public ResponseEntity<?> deleteBookById(@PathVariable int id) {
        bookService.deleteBookById(id);
        System.out.println("Delete successful!");
        List<Book> books = bookService.getAllBooks();
        return ResponseEntity.ok(books);
    }

    @PostMapping("/books")
    public ResponseEntity<?> createBook(@RequestBody BookDTO bookDTO) {
        System.out.println(bookDTO);
        Book book = modelMapper.map(bookDTO, Book.class);
        System.out.println(book);
        return ResponseEntity.ok(bookService.createBook(book));
    }

    @DeleteMapping("/booksDel1/{id}")
    public ResponseEntity<?> deleteBookById1(@PathVariable int id) {
        return ResponseEntity.ok(null);
    }

    @PutMapping ("/books/{id}")
    public ResponseEntity<?> updateBook(@PathVariable int id, @RequestBody Book bookName){
        Book book = bookService.updateBook(id,bookName);
        if (book != null) {
            BookDTO bookDTO = modelMapper.map(book, BookDTO.class);
            return ResponseEntity.ok(bookDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
