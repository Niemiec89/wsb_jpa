package com.jpacourse.persistance.dao.impl;

import com.jpacourse.persistance.dao.AddressDao;
import com.jpacourse.persistance.entity.AddressEntity;
import org.springframework.stereotype.Repository;

@Repository
public class AddressDaoImpl extends AbstractDao<AddressEntity, Long> implements AddressDao
{

}
