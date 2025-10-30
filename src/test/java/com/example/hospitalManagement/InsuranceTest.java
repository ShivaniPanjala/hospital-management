package com.example.hospitalManagement;

import com.example.hospitalManagement.dto.CreateAppointmentRequestDto;
import com.example.hospitalManagement.service.AppointmentService;
import com.example.hospitalManagement.service.InsuranceService;
import com.example.hospitalManagement.entity.Appointment;
import com.example.hospitalManagement.entity.Insurance;
import com.example.hospitalManagement.entity.Patient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalDateTime;

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

        var newPAtient = insuranceService.disaccociateInsuranceFromPatient(patient.getId());
        System.out.println(newPAtient);
    }


    @Autowired
    private AppointmentService appointmentService;

    @Test
    public void testCreateAppointment() {
        Appointment appointment = Appointment.builder()
                .appointmentTime(LocalDateTime.of(2025, 11, 1, 14, 0, 0))
                .reason("Cancer")
                .build();

        CreateAppointmentRequestDto dto = new CreateAppointmentRequestDto();
        dto.setDoctorId(1L);
        dto.setPatientId(2L);
        dto.setReason("Cancer");
        dto.setAppointmentTime(LocalDateTime.of(2025, 11, 1, 14, 0, 0));

        var newAppointment = appointmentService.createNewAppointment(dto);
        System.out.println(newAppointment);


        /* reAssignAppointmentToAnotherDoctor(),
        you call 'doctor.getAppointments().add(appointment)' *after* fetching the doctor.
        But since the method is NOT annotated with @Transactional,
         the Hibernate Session that loaded the Doctor entity is already CLOSED
         by the time you access the lazy collection.
         So when Hibernate tries to fetch the lazy "appointments" collection,
          there’s no active session to load it, leading to LazyInitializationException.

           ✅ Fix:
          Add @Transactional to the 'reAssignAppointmentToAnotherDoctor()' method

         */

        var updateAppointment = appointmentService.reAssignAppointmentToAnotherDoctor(newAppointment.getId(), 3L);
        System.out.println(updateAppointment);
    }
}

