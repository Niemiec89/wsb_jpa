package com.jpacourse.service;

import com.jpacourse.dto.DoctorTO;

public interface DoctorService
{
    DoctorTO findById(final Long id);
}