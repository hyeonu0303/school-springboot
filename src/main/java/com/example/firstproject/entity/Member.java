package com.example.firstproject.entity;

import com.example.firstproject.dto.MemberForm;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
@Entity
public class Member {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Column
  private String name;
  @Column
  private String userId;
  @Column
  private String password;
  @Column
  private String phoneNumber;
  @Column
  private String email;
  @Column
  private String address;



  public void update(String name, String userId, String password, String phoneNumber, String email, String address) {
    this.name = name;
    this.userId = userId;
    this.password = password;
    this.phoneNumber = phoneNumber;
    this.email = email;
    this.address = address;
  }
}


