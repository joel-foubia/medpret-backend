package com.medpret.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "loans")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Loan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "equipment_id", nullable = false)
    private Equipment equipment;

    @Column(nullable = false)
    private LocalDate startDate;

    @Column(nullable = false)
    private LocalDate expectedReturnDate;

    private LocalDate actualReturnDate;

    @Enumerated(EnumType.STRING)
    // @Column(nullable = false)
    // private Status status = Status.ACTIVE;

    // @Column(nullable = false, updatable = false)
    // private LocalDateTime createdAt = LocalDateTime.now();

    @Builder.Default
private Status status = Status.ACTIVE;

@Builder.Default
private LocalDateTime createdAt = LocalDateTime.now();

    private String notes;

    public enum Status {
        ACTIVE, RETURNED, OVERDUE, CANCELLED
    }
}