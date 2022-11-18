package com.company.server.entity;

import lombok.*;

import java.util.UUID;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Contact {
    private UUID id;
    private String fullName;
    private String phoneNumber;
}
