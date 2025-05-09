package com.jpacourse.persistance.dao;

import com.jpacourse.persistance.entity.PatientEntity;
import com.jpacourse.persistance.entity.VisitEntity;

import java.time.LocalDateTime;
import java.util.Collection;

public interface PatientDao extends Dao<PatientEntity, Long> {
    PatientEntity findPatientById(Long patientId);

    Collection<PatientEntity> findPatientsByLastName(String lastName);
    Collection<PatientEntity> findPatientsWithVisitsCountGreaterThan(int visitsCount);
    Collection<PatientEntity> findPatientsByAllergicStatus(Boolean isAllergic);

    PatientEntity saveOrUpdate(PatientEntity patientEntity);
    void deletePatientById(Long patientId);

    VisitEntity addVisitToPatient(Long patientId, Long doctorId, String description, LocalDateTime time);
}
