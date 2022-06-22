package com.example.springpractice.domain.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@Getter
public class Member extends Timestamp {

    @Id
    private String id;

    @Column
    private String password;

    @Column
    private String name;

    @Column
    private int age;

    @Column
    private Gender gender;

    public void update(String name, int age, Gender gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }
}
