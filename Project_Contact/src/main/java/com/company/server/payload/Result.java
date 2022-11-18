package com.company.server.payload;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Result {
    private boolean success;
    private String message;

}
