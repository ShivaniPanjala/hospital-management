package com.example.hospitalManagement.repository;

import com.example.hospitalManagement.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface PatientRepository extends JpaRepository<Patient, Long> {
    Patient findByName(String name);
    Patient findByBirthDate(LocalDate birthDate);
//    Patient findByBirthDateOrEmail(LocalDate birthDate, String email);
//    Optional<Patient> findByBirthDateOrEmail(LocalDate birthDate, String email);

    /**
     * Retrieves a list of patients filtered by either birth date or email.
     *
     * <p>This query returns all patients that match the given birth date or have the specified email address.
     * If both parameters are provided, patients matching either condition will be included in the result set.</p>
     *
     * @param birthDate the birth_date of the patient(s) to search for
     * @param email the email address of the patient(s) to search for
     * @return a list of patients matching the given birth_date or email
     */
    List<Patient> findByBirthDateOrEmail(LocalDate birthDate, String email);


    /**
     * Retrieves a patient whose birth_date falls within the specified date range.
     *
     * <p>This query searches for a patient with a birth_date between the given start and end dates (inclusive).</p>
     *
     * @param startDate the start of the birth_date range (inclusive)
     * @param endDate the end of the birth_date range (inclusive)
     * @return the patient whose birth_date is within the specified range, or {@code null} if none found
     */
    Patient findByBirthDateBetween(LocalDate startDate, LocalDate endDate);


    List<Patient> findByNameContaining(String query);

    List<Patient> findByNameContainingOrderByIdDesc(String query);
}
