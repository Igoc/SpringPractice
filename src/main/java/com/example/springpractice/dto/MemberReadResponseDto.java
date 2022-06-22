package com.example.springpractice.dto;

import com.example.springpractice.domain.entity.Gender;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class MemberReadResponseDto {

    private String id;
    private String name;
    private int age;
    private Gender gender;
}
