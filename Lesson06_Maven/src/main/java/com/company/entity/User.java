package com.company.entity;

import lombok.*;

import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class User {
    Integer id;
    String userName;
    String password;
    List<String > subjects;
}
