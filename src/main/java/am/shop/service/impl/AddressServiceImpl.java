package am.shop.service.impl;

import am.shop.model.Address;
import am.shop.repository.AddressRepository;
import am.shop.service.AddressService;
import am.shop.util.exceptions.DuplicateException;
import am.shop.util.exceptions.NotFoundExcaption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressRepository addressRepository;

    @Override
    public Address getById(int id) throws NotFoundExcaption {
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
    public void crateAddress(Address address) throws DuplicateException {
        int dupCount = addressRepository.countByAddress(address);
        if (dupCount > 0) {
            throw new DuplicateException("duplication address");
        }
        addressRepository.save(address);
    }
}
