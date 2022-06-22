package com.example.springpractice.dto;

import com.example.springpractice.domain.entity.Gender;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberUpdateRequestDto {

    private String name;
    private int age;
    private Gender gender;
}
