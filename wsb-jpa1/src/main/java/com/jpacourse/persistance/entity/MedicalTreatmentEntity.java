package com.jpacourse.persistance.entity;

import com.jpacourse.persistance.enums.TreatmentType;

import javax.persistence.*;

@Entity
@Table(name = "medical_treatment")
public class MedicalTreatmentEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String description;

	@Enumerated(EnumType.STRING)
	private TreatmentType type;

	@ManyToOne(optional = false)
	@JoinColumn(name = "visit_id")
	private VisitEntity visit;

	public MedicalTreatmentEntity() {
	}

	public MedicalTreatmentEntity(String description, TreatmentType type, VisitEntity visit) {
		this.description = description;
		this.type = type;
		this.visit = visit;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public TreatmentType getType() {
		return type;
	}

	public void setType(TreatmentType type) {
		this.type = type;
	}

	public VisitEntity getVisit() {
		return visit;
	}

	public void setVisit(VisitEntity visit) {
		this.visit = visit;
	}
}
