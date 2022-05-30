package am.shop.service;

import am.shop.model.Address;
import am.shop.util.exceptions.DuplicateException;
import am.shop.util.exceptions.NotFoundExcaption;

import java.util.List;

public interface AddressService {

    Address getById(long id) throws NotFoundExcaption;

    List<Address> getByAll() throws NotFoundExcaption;

    void crateAddress(Address address) throws DuplicateException, NotFoundExcaption;

    void editAddress(Address address);


}
