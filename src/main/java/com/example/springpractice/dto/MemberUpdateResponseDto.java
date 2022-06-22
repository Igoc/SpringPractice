package com.example.springpractice.dto;

import com.example.springpractice.domain.entity.Gender;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class MemberUpdateResponseDto {

    private String previousName;
    private String currentName;
    private int previousAge;
    private int currentAge;
    private Gender previousGender;
    private Gender currentGender;
}
