package am.shop.service;

import am.shop.model.Country;
import am.shop.util.exceptions.DuplicateException;
import am.shop.util.exceptions.NotFoundExcaption;

import java.util.List;

public interface CountryService {

    Country getById(int id) throws NotFoundExcaption;

    List<Country> getByAll() throws NotFoundExcaption;

    void crateCountry(Country country) throws DuplicateException;

    boolean existsById(int id);

    void editCountry(Country country) throws DuplicateException;
}
