package com.example.hospitalManagement.Service;

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
        Patient p1 = patientRepository.findById(id).orElseThrow();

        Patient p2 = patientRepository.findById(id).orElseThrow();

        return p1;
    }

}
