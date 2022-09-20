package com.example.demospringboot.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Set;

@NoArgsConstructor
@Getter
@Setter
@Entity
@ToString
@Table(name = "theloaisach")
public class BookType implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ma_the_loai")
    private int typeId;

    @Column(name = "ten_the_loai")
    private String typeName;

    @OneToMany(mappedBy = "bookType")
    private Set<Book> book ;
}
