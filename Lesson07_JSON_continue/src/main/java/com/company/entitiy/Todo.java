package com.company.entitiy;

import lombok.Data;

@Data
public class Todo {
    private Integer id;
    private Integer userId;
    private String title;
    private boolean completed;
}
