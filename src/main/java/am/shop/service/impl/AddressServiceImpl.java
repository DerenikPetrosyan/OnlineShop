package am.shop.service.impl;

import am.shop.model.Address;
import am.shop.repository.AddressRepository;
import am.shop.service.AddressService;
import am.shop.service.CountryService;
import am.shop.service.StateService;
import am.shop.util.exceptions.DuplicateException;
import am.shop.util.exceptions.NotFoundExcaption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private StateService stateService;

    @Autowired
    private CountryService countryService;

    @Override
    public Address getById(long id) throws NotFoundExcaption {
        Address address = addressRepository.getById(id);
        if (address == null) {
            throw new NotFoundExcaption();
        }
        return address;
    }

    @Override
    public List<Address> getByAll() throws NotFoundExcaption {

        return addressRepository.findAll();
    }

    @Override
    public void crateAddress(Address address) throws  NotFoundExcaption {
        addressCreationChecks(address);
        addressRepository.save(address);
    }

    public void addressCreationChecks(Address address) throws NotFoundExcaption {

        if (address.getState() != null) {
            if (stateService.getById(address.getState().getId()) == null) {
                throw new NotFoundExcaption("not found state");
            }
        }
        else if (countryService.getById(address.getCountry().getId()) == null) {
            throw new NotFoundExcaption("not found country");
        }
    }

    @Override
    public void editAddress(Address address) {
        addressRepository.save(address);
    }
}
