package com.example.hospitalManagement.entity;

import com.example.hospitalManagement.entity.type.BloodGroupType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@ToString
@Getter
@Setter
// Maps this entity to the database table named "patient_tbl"
@Table(
        name = "patient",
        // Define unique constraints to prevent duplicate records for these fields
        uniqueConstraints = {
                // Ensures that no two patients can have the same email
//                @UniqueConstraint(name = "unique_patient_email", columnNames = {"email"}),

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

    @Column(nullable = false)
    private String name;

    private LocalDate birthDate;

    @Column(unique = true, nullable = false, length = 40)
    // Defines a database column with the following constraints:
// - unique = true → No two rows can have the same value for this field
// - nullable = false → Field cannot be null (must have a value)
// - length = 40 → Limits the maximum length of the column to 40 characters
    private String email;

    @ToString.Exclude
    private String gender;


    // Automatically sets the timestamp when the record is first created:
// - @CreationTimestamp → Hibernate fills this field with the current time when inserting the record
// - updatable = false → Once set, this value cannot be updated later
    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime createdAt;

    @Enumerated(EnumType.STRING )
    private BloodGroupType bloodGroup;

    // Establishes a one-to-one relationship between this entity and the Insurance entity.
    // The @JoinColumn specifies the foreign key column ("patient_insurance_id") in this table
    // that references the primary key of the Insurance table
    @OneToOne
    @JoinColumn(name = "patient_insurance_id") // foreign key in Patient table // owning side
    private Insurance insurance;

    /*
    Establishes a one-to-many relationship between Patient and Appointment.
    One patient can have many appointments, but each appointment belongs to only one patient.
    The 'mappedBy' attribute indicates that this is the inverse (non-owning) side of the relationship,
    and the 'patient' field in the Appointment entity owns the relationship and contains the foreign key.
     */

    @OneToMany(mappedBy = "patient") //inverse side
    private List<Appointment> appointments;
}
