package com.example.security.entity;

import jakarta.persistence.*;

import java.time.Instant;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "refreshtoken")
public class RefreshToken {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;

  @OneToOne
  @JoinColumn(name = "user_id", referencedColumnName = "id")
  private User user;

  @Column(nullable = false, unique = true)
  private String token;

  @Column(nullable = false)
  private Instant expiryDate;

}