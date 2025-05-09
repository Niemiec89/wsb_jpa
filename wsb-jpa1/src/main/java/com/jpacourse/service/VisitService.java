package com.jpacourse.service;

import com.jpacourse.dto.VisitTO;

import java.util.Collection;

public interface VisitService
{
    VisitTO findById(final Long id);

    public Collection<VisitTO> findAllByPatientId(final Long patientId);
}