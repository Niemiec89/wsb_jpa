package com.jpacourse.service.impl;

import com.jpacourse.dto.VisitTO;
import com.jpacourse.mapper.VisitMapper;
import com.jpacourse.persistance.dao.VisitDao;
import com.jpacourse.persistance.entity.VisitEntity;
import com.jpacourse.service.VisitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.stream.Collectors;

@Service
@Transactional
public class VisitServiceImpl implements VisitService
{
    private final VisitDao visitDao;

    @Autowired
    public VisitServiceImpl(VisitDao pVisitDao){
        visitDao = pVisitDao;
    }

    @Override
    public VisitTO findById(Long id)
    {
        final VisitEntity entity = visitDao.findOne(id);

        return VisitMapper.mapToTO(entity);
    }

    @Override
    public Collection<VisitTO> findAllByPatientId(Long patientId) {
        final Collection<VisitEntity> entities = visitDao.findByPatient(patientId);

        return entities
                .stream()
                .map(VisitMapper::mapToTO)
                .collect(Collectors.toList());
    }
}