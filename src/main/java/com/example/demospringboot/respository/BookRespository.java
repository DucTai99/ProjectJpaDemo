package com.example.demospringboot.respository;

import com.example.demospringboot.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRespository extends JpaRepository<Book, Integer> {
    void deleteBookByBookId(int id);
}
