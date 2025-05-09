package com.jpacourse.dto;

import java.time.LocalDate;
import java.util.Collection;

public class PatientTO {

    private Long id;

    private String firstName;

    private String lastName;

    private String telephoneNumber;

    private String email;

    private String patientNumber;

    private LocalDate dateOfBirth;

    private AddressTO address;

    private Boolean allergic;

    private Collection<VisitTO> visits;

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
        this.firstName = (firstName != null) ? firstName.trim() : null;
    }

    public String getLastName() {
        return lastName;
    }


    public void setLastName(String lastName) {
        this.lastName = (lastName != null) ? lastName.trim() : null;
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
        this.email = (email != null) ? email.toLowerCase() : null;
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

    public AddressTO getAddress() {
        return address;
    }


    public void setAddress(AddressTO address) {
        this.address = address;
    }

    public Boolean getAllergic() {
        return allergic;
    }

    public void setAllergic(Boolean allergic) {
        this.allergic = allergic;
    }

    public Collection<VisitTO> getVisits() {
        return visits;
    }

    public void setVisits(Collection<VisitTO> visits) {
        this.visits = visits;


    }



}
