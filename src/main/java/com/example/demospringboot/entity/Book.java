package com.example.demospringboot.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

@NoArgsConstructor
@Getter
@Setter
@Entity
@ToString
@Table(name = "sach")
public class Book implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ma_sach")
    private int bookId;

    @Column(name = "ten_sach")
    private String bookName;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "loai_sach" ,nullable=false)
    private BookType bookType;

    @Column(name = "gia")
    private double price;
    @Column(name = "so_luong")
    private int quantity;
    @Column(name = "ten_tac_gia")
    private String authorName;
    @Column(name = "hinh_anh")
    private String image;
    @Column(name = "mo_ta")
    private String description;
    @Column(name = "khuyen_mai")
    private String sale;
    @Column(name = "ngay_xuat_ban")
    private Date releaseDate;
}
