package com.example.springpractice.repository;

import com.example.springpractice.domain.entity.Gender;
import com.example.springpractice.domain.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MemberRepository extends JpaRepository<Member, String> {

    List<Member> findAllByAgeAndGenderNotOrderByCreatedDateAsc(int age, Gender gender);
}
