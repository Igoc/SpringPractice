package com.example.springpractice.dto;

import com.example.springpractice.domain.entity.Gender;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberCreateRequestDto {

    private String id;
    private String password;
    private String name;
    private int age;
    private Gender gender;
}
