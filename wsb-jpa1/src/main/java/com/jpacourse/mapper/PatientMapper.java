package com.jpacourse.mapper;

import com.jpacourse.dto.PatientTO;
import com.jpacourse.persistance.entity.PatientEntity;

import java.util.stream.Collectors;

public final class PatientMapper {

    private PatientMapper() { }

    public static PatientTO mapToTO(final PatientEntity patientEntity) {
        if (patientEntity == null) {
            return null;
        }

        PatientTO patientTO = new PatientTO();
        patientTO.setId(patientEntity.getId());
        patientTO.setAddress(AddressMapper.mapToTO(patientEntity.getAddress()));
        patientTO.setPatientNumber(patientEntity.getPatientNumber());
        patientTO.setEmail(patientEntity.getEmail());
        patientTO.setDateOfBirth(patientEntity.getDateOfBirth());
        patientTO.setLastName(patientEntity.getLastName());
        patientTO.setFirstName(patientEntity.getFirstName());
        patientTO.setTelephoneNumber(patientEntity.getTelephoneNumber());
        patientTO.setAllergic(patientEntity.getIsAllergic());

        if (patientEntity.getVisits() != null) {
            patientTO.setVisits(patientEntity.getVisits().stream()
                    .map(VisitMapper::mapForPatientToTO)
                    .collect(Collectors.toList()));
        }


        return patientTO;
    }


    public static PatientTO mapForVisitToTO(final PatientEntity patientEntity) {
        if (patientEntity == null) {
            return null;
        }


        PatientTO patientTO = new PatientTO();
        patientTO.setId(patientEntity.getId());
        patientTO.setAddress(AddressMapper.mapToTO(patientEntity.getAddress()));
        patientTO.setPatientNumber(patientEntity.getPatientNumber());
        patientTO.setEmail(patientEntity.getEmail());
        patientTO.setDateOfBirth(patientEntity.getDateOfBirth());
        patientTO.setLastName(patientEntity.getLastName());
        patientTO.setFirstName(patientEntity.getFirstName());
        patientTO.setTelephoneNumber(patientEntity.getTelephoneNumber());
        patientTO.setAllergic(patientEntity.getIsAllergic());

        return patientTO;
    }


    public static PatientEntity mapToEntity(final PatientTO patientTO) {
        if (patientTO == null) {
            return null;
        }

        PatientEntity patientEntity = new PatientEntity();
        patientEntity.setId(patientTO.getId());
        patientEntity.setAddress(AddressMapper.mapToEntity(patientTO.getAddress()));
        patientEntity.setPatientNumber(patientTO.getPatientNumber());
        patientEntity.setEmail(patientTO.getEmail());
        patientEntity.setDateOfBirth(patientTO.getDateOfBirth());
        patientEntity.setLastName(patientTO.getLastName());
        patientEntity.setFirstName(patientTO.getFirstName());
        patientEntity.setTelephoneNumber(patientTO.getTelephoneNumber());
        patientEntity.setIsAllergic(patientTO.getAllergic());


        if (patientTO.getVisits() != null) {
            patientEntity.setVisits(patientTO.getVisits().stream()
                    .map(VisitMapper::mapForPatientToEntity)
                    .collect(Collectors.toList()));
        }

        return patientEntity;
    }
}
