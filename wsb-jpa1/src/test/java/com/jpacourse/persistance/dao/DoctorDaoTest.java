package com.jpacourse.persistance.dao;

import com.jpacourse.persistance.entity.DoctorEntity;
import com.jpacourse.persistance.entity.AddressEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class DoctorDaoTest {
    public void testShouldFindDoctorByID()
    {
        assertThat(doctorEntity).isNotNull();
        final VisitEntity visitEntity = doctorEntity.getVisits().get(0);
        assertThat(visitEntity).isNotNull();
    }
    @Transactional
    @Test
    public void testShouldSaveCascade() {
        // given
        DoctorEntity doctorEntity = new DoctorEntity();
        doctorEntity.setFirstName("John");
        doctorEntity.setSpecialization(Specialization.GP);


        AddressEntity addressEntity = new AddressEntity();
        addressEntity.setAddressLine1("123 Main St");

    }
}