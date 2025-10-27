package com.example.hospitalManagement.service;

import com.example.hospitalManagement.entity.Insurance;
import com.example.hospitalManagement.entity.Patient;
import com.example.hospitalManagement.repository.InsuranceRepository;
import com.example.hospitalManagement.repository.PatientRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InsuranceService {
    private final InsuranceRepository insuranceRepository;
    private final PatientRepository patientRepository;

    // Assigns an Insurance to a Patient and maintains bidirectional consistency
    @Transactional // Opens a transaction so all DB operations happen atomically
    public Patient assignInsuranceToPatient(Insurance insurance, Long patientId) {

        // Fetch the patient from the database; throw an error if not found
        Patient patient = patientRepository.findById(patientId)
                .orElseThrow(() -> new EntityNotFoundException("Patient not found with id : " +patientId));

        /* Set the insurance for the patient (owning side)
        // Since the patient is a managed entity inside the transaction,
         Hibernate tracks this change (dirty checking) and updates it automatically at commit time
        */
        patient.setInsurance(insurance);

        /* Set the reverse relationship to maintain bidirectional consistency
           This ensures both Patient and Insurance know about each other in memory
         */
        insurance.setPatient(patient); //bidirectional consistency maintainence


        // Return the updated patient; changes will be persisted automatically on transaction commit
        return patient;
    }
    @Transactional
    public Patient disaccociateInsuranceFromPatient(Long patientId) {
        Patient patient = patientRepository.findById(patientId)
                .orElseThrow(() -> new EntityNotFoundException("Patient not found with id: " + patientId));

        patient.setInsurance(null);
        return patient;
    }
}
