package com.example.demospringboot.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Setter
@Getter
@NoArgsConstructor
@ToString
public class BookDTO implements Serializable {
    private int bookId;
    private String bookName;
    private double price;
    private int quantity ;
    private String authorName ;
    private String image;
    private String description;
    private String sale;
    private BookTypeDTO bookTypeDTO;
}




