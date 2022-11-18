package com.company.entity;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Book {
    private Integer id;
    private String title;
    private String author;
    private Double price;
}
