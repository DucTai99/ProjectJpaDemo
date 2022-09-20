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
public class BookTypeDTO implements Serializable {
    private int typeId;
    private String typeName;
}
