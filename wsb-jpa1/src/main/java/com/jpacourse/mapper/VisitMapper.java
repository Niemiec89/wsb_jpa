package com.jpacourse.mapper;

import com.jpacourse.dto.VisitTO;
import com.jpacourse.persistance.entity.VisitEntity;

import java.util.stream.Collectors;

public class VisitMapper {

    public static VisitTO mapForPatientToTO(final VisitEntity visitEntity) {
        if (visitEntity == null) {
            return null;
        }

        VisitTO visitTO = new VisitTO();
        visitTO.setId(visitEntity.getId());
        visitTO.setDescription(visitEntity.getDescription());
        visitTO.setDoctor(DoctorMapper.mapToTO(visitEntity.getDoctor()));
        visitTO.setTime(visitEntity.getTime());


        if (visitEntity.getMedicalTreatments() != null) {
            visitTO.setTreatments(visitEntity.getMedicalTreatments().stream()
                    .map(MedicalTreatmentMapper::mapToTO)
                    .collect(Collectors.toList()));
        }

        return visitTO;
    }

    public static VisitTO mapToTO(final VisitEntity visitEntity) {
        if (visitEntity == null) {
            return null;
        }

        VisitTO visitTO = new VisitTO();
        visitTO.setId(visitEntity.getId());
        visitTO.setDescription(visitEntity.getDescription());
        visitTO.setDoctor(DoctorMapper.mapToTO(visitEntity.getDoctor()));
        visitTO.setTime(visitEntity.getTime());

        if (visitEntity.getMedicalTreatments() != null) {
            visitTO.setTreatments(visitEntity.getMedicalTreatments().stream()
                    .map(MedicalTreatmentMapper::mapToTO)
                    .collect(Collectors.toList()));
        }


        visitTO.setPatientEntity(PatientMapper.mapForVisitToTO(visitEntity.getPatient()));

        return visitTO;
    }

    public static VisitEntity mapForPatientToEntity(final VisitTO visitTO) {
        if (visitTO == null) {
            return null;
        }


        VisitEntity visitEntity = new VisitEntity();
        visitEntity.setId(visitTO.getId());
        visitEntity.setDescription(visitTO.getDescription());
        visitEntity.setDoctor(DoctorMapper.mapToEntity(visitTO.getDoctor()));
        visitEntity.setTime(visitTO.getTime());

        if (visitTO.getTreatments() != null) {
            visitEntity.setMedicalTreatments(visitTO.getTreatments().stream()
                    .map(MedicalTreatmentMapper::mapToEntity)
                    .collect(Collectors.toList()));
        }

        return visitEntity;
    }

    public static VisitEntity mapToEntity(final VisitTO visitTO) {
        if (visitTO == null) {
            return null;
        }

        VisitEntity visitEntity = new VisitEntity();
        visitEntity.setId(visitTO.getId());
        visitEntity.setDescription(visitTO.getDescription());
        visitEntity.setDoctor(DoctorMapper.mapToEntity(visitTO.getDoctor()));
        visitEntity.setTime(visitTO.getTime());


        if (visitTO.getTreatments() != null) {
            visitEntity.setMedicalTreatments(visitTO.getTreatments().stream()
                    .map(MedicalTreatmentMapper::mapToEntity)
                    .collect(Collectors.toList()));
        }

        visitEntity.setPatient(PatientMapper.mapToEntity(visitTO.getPatientEntity()));

        return visitEntity;

    }


}

