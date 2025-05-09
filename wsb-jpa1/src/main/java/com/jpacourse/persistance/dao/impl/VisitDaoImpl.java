package com.jpacourse.persistance.dao.impl;

import com.jpacourse.persistance.dao.VisitDao;
import com.jpacourse.persistance.entity.VisitEntity;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public class VisitDaoImpl extends AbstractDao<VisitEntity, Long> implements VisitDao {

    @Override
    public Collection<VisitEntity> findByPatient(Long patientId) {
        return entityManager.createQuery("SELECT v FROM VisitEntity v WHERE v.patient.id = :patientId", VisitEntity.class)
                .setParameter("patientId", patientId)
                .getResultList();
    }
}
