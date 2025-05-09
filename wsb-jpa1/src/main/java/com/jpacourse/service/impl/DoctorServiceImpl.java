package com.jpacourse.service.impl;

import com.jpacourse.dto.DoctorTO;
import com.jpacourse.mapper.DoctorMapper;
import com.jpacourse.persistance.dao.DoctorDao;
import com.jpacourse.persistance.entity.DoctorEntity;
import com.jpacourse.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class DoctorServiceImpl implements DoctorService
{
    private final DoctorDao doctorDao;

    @Autowired
    public DoctorServiceImpl(DoctorDao pDoctorDao){
        doctorDao = pDoctorDao;
    }

    @Override
    public DoctorTO findById(Long id)
    {
        final DoctorEntity entity = doctorDao.findOne(id);

        return DoctorMapper.mapToTO(entity);
    }
}
