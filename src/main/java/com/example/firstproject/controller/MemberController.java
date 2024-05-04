package com.example.firstproject.controller;

import com.example.firstproject.dto.MemberForm;
import com.example.firstproject.entity.Member;
import com.example.firstproject.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MemberController {
  @Autowired
  MemberRepository memberRepository;
  @GetMapping("/members/register")
  public String newMemberForm() {
    return "members/register";
  }

  @PostMapping("/members/create")
  public String createMember(MemberForm form) {
    System.out.println(form.toString());
    Member saved = form.toEntity();
    Member savePrint = memberRepository.save(saved);
    System.out.println(savePrint.toString());
    return "redirect:/members/hello";
  }

  @GetMapping("/members/hello")
  public String hello() {
    return "members/hello";
  }

  @GetMapping("/members/profile")
  public String profile(Model mo) {
    Iterable<Member> members = memberRepository.findAll();
    mo.addAttribute("members", members);
    System.out.println("회원목록:"+members.toString());
    return "members/profile";
  }

  @GetMapping("/members/edit/{id}")
  public String editMemberForm(Model mo, @PathVariable("id") Long id) {
    Member member = memberRepository.findById(id).orElseThrow(
      () -> new IllegalArgumentException("해당 사용자가 없습니다.")
    );
    mo.addAttribute("member", member);
    return "members/edit";
  }

  @PostMapping("/members/update/{id}")
  public String updateMember(MemberForm form, @PathVariable("id") Long id) {
    Member member = memberRepository.findById(id).orElseThrow(
      () -> new IllegalArgumentException("해당 사용자가 없습니다.")
    );
    System.out.println("수정페이지:"+form.toString());
    member.update(form.getName(), form.getUserId(), form.getPassword(), form.getPhoneNumber(), form.getEmail(), form.getAddress());
    memberRepository.save(member);
    return "redirect:/members/profile";
  }

  @GetMapping("/members/delete/{id}")
  public String deleteMember(@PathVariable("id") Long id) {
    Member member = memberRepository.findById(id).orElseThrow(
      () -> new IllegalArgumentException("해당 사용자가 없습니다.")
    );
    memberRepository.delete(member);
    System.out.println("삭제완료:" + member.toString());
    return "redirect:/members/profile";
  }
}


