package com.jpacourse.persistance.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Collection;

	@Entity
	@Table(name = "patient")
	public class PatientEntity {

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;

		@Column(nullable = false)
		private String firstName;

		@Column(nullable = false)
		private String lastName;

		@Column(nullable = false)
		private String telephoneNumber;

		private String email;

		@Column(nullable = false)
		private String patientNumber;

		@Column(nullable = false)
		private LocalDate dateOfBirth;

		@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
		@JoinColumn(name = "address_id")
		private AddressEntity address;

		@OneToMany(mappedBy = "patient", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE}, fetch = FetchType.LAZY)
		private Collection<VisitEntity> visits;

		@Column(nullable = false, columnDefinition = "BOOLEAN DEFAULT FALSE")
		private Boolean isAllergic;

		public PatientEntity() {
		}

		public PatientEntity(String firstName, String lastName, String telephoneNumber, String email, String patientNumber, LocalDate dateOfBirth, AddressEntity address, Boolean isAllergic) {
			this.firstName = firstName;
			this.lastName = lastName;
			this.telephoneNumber = telephoneNumber;
			this.email = email;
			this.patientNumber = patientNumber;
			this.dateOfBirth = dateOfBirth;
			this.address = address;
			this.isAllergic = isAllergic;
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getFirstName() {
			return firstName;
		}

		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}

		public String getLastName() {
			return lastName;
		}

		public void setLastName(String lastName) {
			this.lastName = lastName;
		}

		public String getTelephoneNumber() {
			return telephoneNumber;
		}

		public void setTelephoneNumber(String telephoneNumber) {
			this.telephoneNumber = telephoneNumber;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getPatientNumber() {
			return patientNumber;
		}

		public void setPatientNumber(String patientNumber) {
			this.patientNumber = patientNumber;
		}

		public LocalDate getDateOfBirth() {
			return dateOfBirth;
		}

		public void setDateOfBirth(LocalDate dateOfBirth) {
			this.dateOfBirth = dateOfBirth;
		}

		public AddressEntity getAddress() {
			return address;
		}

		public void setAddress(AddressEntity address) {
			this.address = address;
		}

		public Collection<VisitEntity> getVisits() {
			return visits;
		}

		public void setVisits(Collection<VisitEntity> visits) {
			this.visits = visits;
		}

		public void addVisit(VisitEntity visit) {
			visits.add(visit);
			visit.setPatient(this);
		}

		public void removeVisit(VisitEntity visit) {
			visits.remove(visit);
			visit.setPatient(null);
		}

		public Boolean getIsAllergic() {
			return isAllergic;
		}

		public void setIsAllergic(Boolean isAllergic) {
			this.isAllergic = isAllergic;
		}
	}
