package com.example.firstproject.dto;

import com.example.firstproject.entity.Member;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@ToString
@Getter
@Setter
public class MemberForm {
  private Long id;
  private String name;
  private String userId;
  private String password;
  private String phoneNumber;
  private String email;
  private String address;
  public Member toEntity() {

    return new Member(id,name,userId,password,phoneNumber,email,address);
  }
}
