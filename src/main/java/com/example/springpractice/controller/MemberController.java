package com.example.springpractice.controller;

import com.example.springpractice.dto.*;
import com.example.springpractice.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/create")
    public MemberCreateResponseDto createMember(@RequestBody MemberCreateRequestDto memberCreateRequestDto) {
        return memberService.join(memberCreateRequestDto);
    }

    @GetMapping("/read/{id}")
    public MemberReadResponseDto readMember(@PathVariable String id) {
        return memberService.findMember(id);
    }

    @GetMapping("/recommend/{id}")
    public List<MemberRecommendResponseDto> recommendMembers(@PathVariable String id) {
        return memberService.recommendMembers(id);
    }

    @PutMapping("/update/{id}")
    public MemberUpdateResponseDto updateMember(@PathVariable String id, @RequestBody MemberUpdateRequestDto memberUpdateRequestDto) {
        return memberService.updateMember(id, memberUpdateRequestDto);
    }

    @DeleteMapping("/delete/{id}")
    public MemberDeleteResponseDto deleteMember(@PathVariable String id) {
        return memberService.deleteMember(id);
    }
}
