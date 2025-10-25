package com.example.hospitalManagement;

import com.example.hospitalManagement.Service.InsuranceService;
import com.example.hospitalManagement.entity.Insurance;
import com.example.hospitalManagement.entity.Patient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

@SpringBootTest
public class InsuranceTest {
    @Autowired //injects the service
    private InsuranceService insuranceService;

    @Test
    public void testInsurance() {
        Insurance insurance = Insurance.builder()
                .policyNumber("HDFC_1234")
                .provider("HDFC")
                .validUntil(LocalDate.of(2030, 12, 6))
                .build(); /* Constructs and returns an actual Insurance object with the specified values.
                            Internally, Lombok’s builder creates a new instance and assigns each property you set above */

        Patient patient = insuranceService.assignInsuranceToPatient(insurance, 1L);

        System.out.println(patient);
    }

}

