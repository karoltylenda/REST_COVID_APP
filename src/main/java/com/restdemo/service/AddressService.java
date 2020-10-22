package com.restdemo.service;

import com.mysql.cj.xdevapi.AddResult;
import com.restdemo.dao.AddressDao;
import com.restdemo.dto.AddressDto;
import com.restdemo.model.Address;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

@RequestScoped
public class AddressService {

    @Inject
    private AddressDao addressDao;

    public List<AddressDto> getAll(){
        List<Address> addressList = addressDao.getAll();
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

    public void addAddress(String city, String district, String postalCode, String street, String streetNr, String localNr) {
        Address address = new Address();
        address.setCity(city);
        address.setDistrict(district);
        address.setPostalCode(postalCode);
        address.setStreet(street);
        address.setStreetNr(streetNr);
        address.setLocalNr(localNr);
        addressDao.create(address);
    }
}
