package com.medpret.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;

   // @Column(nullable = false)
    //private boolean active = true;

//    @Column(nullable = false, updatable = false)
  //  private LocalDateTime createdAt = LocalDateTime.now();

@Builder.Default
private boolean active = true;

@Builder.Default
private LocalDateTime createdAt = LocalDateTime.now();

    public enum Role {
        ADMIN, STAFF, STUDENT
    }
}