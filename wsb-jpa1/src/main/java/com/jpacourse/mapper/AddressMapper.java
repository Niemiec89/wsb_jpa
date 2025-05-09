package com.jpacourse.mapper;

import com.jpacourse.dto.AddressTO;

import com.jpacourse.persistance.entity.AddressEntity;

public final class AddressMapper {

    private AddressMapper() { }

    public static AddressTO mapToTO(AddressEntity addressEntity) {
        if (addressEntity == null) {
            return null;
        }

        AddressTO addressTO = new AddressTO();
        addressTO.setId(addressEntity.getId());
        addressTO.setAddressLine1(addressEntity.getAddressLine1());
        addressTO.setAddressLine2(addressEntity.getAddressLine2() != null ? addressEntity.getAddressLine2() : "");
        addressTO.setCity(addressEntity.getCity());
        addressTO.setPostalCode(addressEntity.getPostalCode());

        return addressTO;
    }

    public static AddressEntity mapToEntity(AddressTO addressTO) {
        if (addressTO == null) {
            return null;
        }

        AddressEntity addressEntity = new AddressEntity();
        addressEntity.setId(addressTO.getId());
        addressEntity.setAddressLine1(addressTO.getAddressLine1());
        addressEntity.setAddressLine2(addressTO.getAddressLine2() != null ? addressTO.getAddressLine2() : "");
        addressEntity.setCity(addressTO.getCity());
        addressEntity.setPostalCode(addressTO.getPostalCode());

        return addressEntity;

    }
}

