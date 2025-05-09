package com.jpacourse.mapper;

import com.jpacourse.dto.MedicalTreatmentTO;
import com.jpacourse.persistance.entity.MedicalTreatmentEntity;

import com.jpacourse.persistance.enums.TreatmentType;

public final class MedicalTreatmentMapper {

    private MedicalTreatmentMapper() { }

    public static MedicalTreatmentTO mapToTO(MedicalTreatmentEntity medicalTreatmentEntity) {
        if (medicalTreatmentEntity == null) {
            return null;
        }

        MedicalTreatmentTO medicalTreatmentTO = new MedicalTreatmentTO();
        medicalTreatmentTO.setId(medicalTreatmentEntity.getId());
        medicalTreatmentTO.setDescription(medicalTreatmentEntity.getDescription());

        if (medicalTreatmentEntity.getType() != null) {
            medicalTreatmentTO.setTreatmentType(medicalTreatmentEntity.getType().name());
        }

        return medicalTreatmentTO;
    }

    public static MedicalTreatmentEntity mapToEntity(MedicalTreatmentTO medicalTreatmentTO) {
        if (medicalTreatmentTO == null) {
            return null;
        }

        MedicalTreatmentEntity medicalTreatmentEntity = new MedicalTreatmentEntity();
        medicalTreatmentEntity.setId(medicalTreatmentTO.getId());  // Ustawiamy ID
        medicalTreatmentEntity.setDescription(medicalTreatmentTO.getDescription());  // Ustawiamy opis

        if (medicalTreatmentTO.getTreatmentType() != null) {
            medicalTreatmentEntity.setType(Enum.valueOf(
                    TreatmentType.class, medicalTreatmentTO.getTreatmentType())
            );


        }

        return medicalTreatmentEntity;

    }


}
