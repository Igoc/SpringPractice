package com.example.springpractice.service;

import com.example.springpractice.domain.entity.Gender;
import com.example.springpractice.domain.entity.Member;
import com.example.springpractice.dto.*;
import com.example.springpractice.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    @Transactional
    public MemberCreateResponseDto join(MemberCreateRequestDto memberCreateRequestDto) {
        Member member = Member.builder()
                .id(memberCreateRequestDto.getId())
                .password(memberCreateRequestDto.getPassword())
                .name(memberCreateRequestDto.getName())
                .age(memberCreateRequestDto.getAge())
                .gender(memberCreateRequestDto.getGender())
                .build();

        memberRepository.save(member);

        return MemberCreateResponseDto.builder()
                .id(member.getId())
                .build();
    }

    public MemberReadResponseDto findMember(String id) {
        Member member = memberRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 아이디"));

        return MemberReadResponseDto.builder()
                .id(member.getId())
                .name(member.getName())
                .age(member.getAge())
                .gender(member.getGender())
                .build();
    }

    public List<MemberRecommendResponseDto> recommendMember(String id) {
        Member member = memberRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 아이디"));

        List<Member> members = memberRepository.findAllByAgeAndGenderNotOrderByCreatedDateAsc(member.getAge(), member.getGender());
        List<MemberRecommendResponseDto> output = new ArrayList<>();

        for (Member m : members) {
            output.add(MemberRecommendResponseDto.builder()
                    .id(m.getId())
                    .name(m.getName())
                    .age(m.getAge())
                    .gender(m.getGender())
                    .build());
        }

        return output;
    }

    @Transactional
    public MemberUpdateResponseDto updateMember(String id, MemberUpdateRequestDto memberUpdateRequestDto) {
        Member member = memberRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 아이디"));

        String name = member.getName();
        int age = member.getAge();
        Gender gender = member.getGender();

        member.update(memberUpdateRequestDto.getName(),
                memberUpdateRequestDto.getAge(),
                memberUpdateRequestDto.getGender());

        return MemberUpdateResponseDto.builder()
                .previousName(name)
                .currentName(member.getName())
                .previousAge(age)
                .currentAge(member.getAge())
                .previousGender(gender)
                .currentGender(member.getGender())
                .build();
    }

    @Transactional
    public MemberDeleteResponseDto deleteMember(String id) {
        Member member = memberRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 아이디"));

        memberRepository.delete(member);

        return MemberDeleteResponseDto.builder()
                .id(id)
                .build();
    }
}
