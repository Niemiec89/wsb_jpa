package com.jpacourse.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.time.LocalDateTime;
import java.util.Collection;

public class VisitTO {

    private Long id;
    private String description;
    private LocalDateTime time;

    @JsonIgnoreProperties({"doctor"})
    private DoctorTO doctor;

    @JsonIgnoreProperties({"patientEntity"})
    private PatientTO patientEntity;

    private Collection<MedicalTreatmentTO> treatments;

    public Collection<MedicalTreatmentTO> getTreatments() {
        return treatments;
    }

    public void setTreatments(Collection<MedicalTreatmentTO> treatments) {
        this.treatments = treatments;
    }

    @JsonIgnore
    public PatientTO getPatientEntity() {
        return patientEntity;
    }

    public void setPatientEntity(PatientTO patientEntity) {
        this.patientEntity = patientEntity;
    }

    @JsonIgnore
    public DoctorTO getDoctor() {
        return doctor;
    }

    public void setDoctor(DoctorTO doctor) {
        this.doctor = doctor;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description != null ? description.trim() : null;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
