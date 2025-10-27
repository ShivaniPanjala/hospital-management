package com.example.hospitalManagement.service;

import com.example.hospitalManagement.entity.Patient;
import com.example.hospitalManagement.repository.PatientRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PatientService {
    public final PatientRepository patientRepository;

    @Transactional
    public Patient getPatientById(Long id) {

        // Fetch patient from the database
        Patient p1 = patientRepository.findById(id).orElseThrow();

        // Fetching again will return the same object from the persistence context.
        // Because @Transactional ensures this method runs within a single Hibernate session (one persistence context).
        // So, Hibernate doesn't create a new session or execute another query — it reuses the already managed entity.
        Patient p2 = patientRepository.findById(id).orElseThrow();

        // Update the patient's name
        p1.setName("Madhav");

        // Hibernate performs dirty checking:
        // Since p1 is a managed entity (same ID), Hibernate will not insert a new record.
        // Instead, it will automatically generate an UPDATE query for this change when the transaction commits.

        return p1;
    }

    public Patient savePatient(Patient newPatient) {
        return patientRepository.save(newPatient);
    }
}
