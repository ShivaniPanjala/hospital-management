package com.example.hospitalManagement.controller;

import com.example.hospitalManagement.exception.ResourceNotFoundException;
import com.example.hospitalManagement.service.DoctorService;
import com.example.hospitalManagement.dto.DoctorResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/public")
@RequiredArgsConstructor
public class HospitalController {
    private final DoctorService doctorService;

    @GetMapping("/doctors")
    public ResponseEntity<List<DoctorResponseDto>> getAllDoctors() {
        List<DoctorResponseDto> doctors = doctorService.getAllDoctors();
        if (doctors.isEmpty()) {
            throw new ResourceNotFoundException("No doctors found");
        }
        return ResponseEntity.ok(doctors);
//        return ResponseEntity.ok(doctorService.getAllDoctors());
    }

}
