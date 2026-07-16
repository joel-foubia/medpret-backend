package com.medpret.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "equipment")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Equipment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    private String description;

    @Column(unique = true)
    private String serialNumber;

    private String category;

    private String qrCode;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
   @Builder.Default
private Status status = Status.AVAILABLE;

@Builder.Default
private LocalDateTime createdAt = LocalDateTime.now();

    public enum Status {
        AVAILABLE, LOANED, MAINTENANCE, RETIRED
    }
}