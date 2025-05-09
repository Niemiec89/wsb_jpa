package com.jpacourse.persistance.dao;

import com.jpacourse.persistance.entity.VisitEntity;

import java.util.Collection;

public interface VisitDao extends Dao<VisitEntity, Long>
{
    Collection<VisitEntity> findByPatient(Long patientId);
}