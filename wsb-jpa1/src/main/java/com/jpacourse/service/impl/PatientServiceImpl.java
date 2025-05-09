package com.jpacourse.service.impl;

import com.jpacourse.dto.PatientTO;
import com.jpacourse.mapper.PatientMapper;
import com.jpacourse.persistance.dao.PatientDao;
import com.jpacourse.persistance.entity.PatientEntity;
import com.jpacourse.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@Transactional
public class PatientServiceImpl implements PatientService
{
    private final PatientDao patientDao;

    @Autowired
    public PatientServiceImpl(PatientDao pPatientDao) {
        patientDao = pPatientDao;
    }

    @Override
    @Transactional
    public void deletePatient(Long patientId) {
        this.patientDao.deletePatientById(patientId);
    }

    @Override
    @Transactional(readOnly = true)
    public PatientTO getPatientById(Long patientId) {
        PatientEntity patientEntity = this.patientDao.findPatientById(patientId);
        return PatientMapper.mapToTO(patientEntity);
    }

    @Override
    @Transactional
    public PatientTO saveOrUpdatePatient(PatientTO patientTO) {
        PatientEntity patientEntity = PatientMapper.mapToEntity(patientTO);
        PatientEntity savedEntity = this.patientDao.saveOrUpdate(patientEntity);
        return PatientMapper.mapToTO(savedEntity);
    }

    @Override
    @Transactional
    public void addVisit(Long patientId, Long doctorId, String description, LocalDateTime time) {
        this.patientDao.addVisitToPatient(patientId, doctorId, description, time);
    }
}