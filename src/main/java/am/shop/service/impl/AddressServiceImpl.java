package am.shop.service.impl;

import am.shop.model.Address;
import am.shop.model.City;
import am.shop.model.Country;
import am.shop.model.State;
import am.shop.repository.AddressRepository;
import am.shop.service.AddressService;
import am.shop.service.CityService;
import am.shop.service.CountryService;
import am.shop.service.StateService;
import am.shop.util.exceptions.BadRequestException;
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

    @Autowired
    private CityService cityService;

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
    public void crateAddress(Address address) throws NotFoundExcaption, BadRequestException {
        addressCreationChecks(address);
        addressRepository.save(address);
    }

    public void addressCreationChecks(Address address) throws NotFoundExcaption, BadRequestException {
        //stuguma tvacs countryn  ka te che DB-um
        if (!countryService.existsById(address.getCountry().getId())) {
            throw new NotFoundExcaption("not found country");
            //stuguma tvacs  state ka DB-um
        } else if (!stateService.existsById(address.getState().getId())) {
            throw new NotFoundExcaption("not found state");
            //stuguma cityn ete null chi tena ka db um te che
        } else if (address.getCity() != null) {
            if (!cityService.existsById(address.getCity().getId())) {
                throw new NotFoundExcaption("not found city");
            }
        }

        //stugel vor Cityn patkani chisht Statein Statenel chisht Countryyn\
        State state1 = stateService.getById(address.getState().getId());
        City city1 = cityService.getById(address.getCity().getId());

        if (state1.getCountry().getId() != address.getCountry().getId()) {
            throw new BadRequestException();
        } else if (address.getCity() != null) {
            if (city1.getState().getId() != address.getState().getId()) {
                throw new BadRequestException();
            }
        }


    }

    @Override
    public void editAddress(Address address) throws NotFoundExcaption, BadRequestException {
        addressCreationChecks(address);
        addressRepository.save(address);
    }
}
