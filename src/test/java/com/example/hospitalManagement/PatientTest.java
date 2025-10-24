package com.example.hospitalManagement;

import com.example.hospitalManagement.Service.PatientService;
import com.example.hospitalManagement.entity.Patient;
import com.example.hospitalManagement.entity.type.BloodGroupType;
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

    @Test
    public void testRepositoryCustomMethods() {
        Patient p1 = patientRepository.findByName("Smith");
        Patient p2 = patientRepository.findByBirthDate(LocalDate.of(2000, 5, 15));

        List<Patient> patientList = patientRepository.findByBirthDateOrEmail(LocalDate.of(2000, 5, 15), "smith@example.com");
        for(Patient patient: patientList){
            System.out.println(patient);
        }


        List<Patient> pl = patientRepository.findByNameContaining("it");
        for(Patient patient: pl){
            System.out.println(patient);
        }

        List<Patient> p = patientRepository.findByNameContainingOrderByIdDesc("it");
        for(Patient patient: p){
            System.out.println(patient);
        }
    }

    @Test
    public void testRepositoryCustomQueries() {
        List<Patient> p1 = patientRepository.findByBloodGroup(BloodGroupType.A_POSITIVE);
        for(Patient Patient: p1) {
            System.out.println(Patient);
        }

        List<Patient> p2 = patientRepository.findByBornAfterDate(LocalDate.of(2000, 4, 1));
        for(Patient Patient: p2) {
            System.out.println(Patient);
        }


        List<Object[]> bloodGroupList = patientRepository.countEachBloodGroupType();
        for(Object[] objects: bloodGroupList ) {
            System.out.println(objects[0] +" "+ objects[1]);
        }

        List<Patient> p4 = patientRepository.findAllPatients();
        for(Patient Patient: p4) {
            System.out.println(Patient);
        }

        int rowsUpdated = patientRepository.updateNameWithId("Shivani", 1L);
        System.out.println(rowsUpdated);


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

