package com.example.hospitalManagement.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CurrentTimestamp;

import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Insurance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 56)
    private String policyNumber;

    @Column(nullable = false, length = 100)
    private String provider;

    @Column(nullable = false)
    private LocalDate validUntil;

    @CurrentTimestamp
    @Column(nullable = false, updatable = false)
    private LocalDate createdAt;

    @OneToOne(mappedBy = "insurance")
    private Patient patient; //inverse side

}
