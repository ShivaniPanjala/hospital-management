package com.example.hospitalManagement.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Entity
@ToString
@Getter
@Setter
// Maps this entity to the database table named "patient_tbl"
@Table(
        name = "patient_tbl",
        // Define unique constraints to prevent duplicate records for these fields
        uniqueConstraints = {
                // Ensures that no two patients can have the same email
                @UniqueConstraint(name = "unique_patient_email", columnNames = {"email"}),
                // Ensures that no two patients can have the same combination of name and birthDate
                @UniqueConstraint(name ="unique_patient_name_birthdate", columnNames = {"name", "birthDate"})
        },
        // Define indexes to improve query performance
        indexes = {
                // Creates an index on the birthDate column for faster searches and filtering by date
                @Index(name ="idx_patient_birth_date", columnList = "birthDate")
        }

)
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private LocalDate birthDate;

    private String email;

    @ToString.Exclude
    private String gender;
}
