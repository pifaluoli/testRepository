package com.mhj.demo.domain;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private String name;
    private Integer age;
    private Pet pet;
}
