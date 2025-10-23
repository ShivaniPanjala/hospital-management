package com.example.hospitalManagement;

import com.example.hospitalManagement.Service.PatientService;
import com.example.hospitalManagement.entity.Patient;
import com.example.hospitalManagement.repository.PatientRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;

@SpringBootTest
public class PatientTest {
    @Autowired
    public PatientRepository patientRepository;


    @Test
    public void testPatientRepository() {
        List<Patient> patientList = patientRepository.findAll();
        System.out.println(patientList);
    }

    @Autowired
    public PatientService patientService;
    @Test
    public void testTransactionMethods() {
//        Patient newPatient = new Patient();
//        newPatient.setName("Nit");
//        newPatient.setEmail("fgvb@example.com");
//        newPatient.setBirthDate(LocalDate.of(2001, 10, 5));
//        newPatient.setGender("Female");
//
//        newPatient = patientService.savePatient(newPatient);


//        Patient patient = patientService.getPatientById(newPatient.getId());

        Patient patient = patientService.getPatientById(1L);
        System.out.println(patient);
    }

}

