package com.restdemo.service;

import com.restdemo.dao.DAO;
import com.restdemo.dto.AddressDto;
import com.restdemo.model.Address;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

@RequestScoped
public class AddressService {

    @Inject
    private DAO<Address> addressDAO;

    public List<AddressDto> getAll(){
        List<Address> addressList = addressDAO.getAll();
        List<AddressDto> addressDtoList = mapAddressListToDtos(addressList);
        return addressDtoList;
    }

    private List<AddressDto> mapAddressListToDtos(List<Address> addressList) {
        return addressList.stream()
                .map(address -> new AddressDto(address.getId(),
                        address.getDistrict(),
                        address.getCity(),
                        address.getPostalCode(),
                        address.getStreet(),
                        address.getStreetNr(),
                        address.getLocalNr(),
                        address.getPatientSet()))
                .collect(Collectors.toList());
    }
}
