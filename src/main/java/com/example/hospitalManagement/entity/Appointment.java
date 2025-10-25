package com.example.hospitalManagement.entity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder

public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDateTime appointmentTime;

    @Column(length = 500)
    private String reason;

    /*
         Defines a many-to-one relationship between Appointment and Patient.
         Many appointments can be associated with one patient.
         The @JoinColumn specifies the foreign key column ("patient_id") in the Appointment table
         that references the primary key of the Patient entity.
    */
    @ManyToOne // Many Appointments to One Patient
    @JoinColumn(name = "patient_id", nullable = false) //patient is required and not nullable,  Owning side
    private Patient patient;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Doctor doctor;
}
