package com.jpacourse.service;

import com.jpacourse.dto.PatientTO;

import java.time.LocalDateTime;

public interface PatientService {
    PatientTO getPatientById(Long patientId);
    PatientTO saveOrUpdatePatient(PatientTO patientTO);

    void deletePatient(Long patientId);
    void addVisit(Long patientId, Long doctorId, String description, LocalDateTime time);
}