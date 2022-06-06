package am.shop.service;

import am.shop.model.City;
import am.shop.model.Color;
import am.shop.util.exceptions.DuplicateException;
import am.shop.util.exceptions.NotFoundExcaption;

import java.util.List;

public interface CityService {


    City getById(long id) throws NotFoundExcaption;

    List<City> getByAll() throws NotFoundExcaption;

    void crateCity(City city) throws DuplicateException, NotFoundExcaption;

    List<City> getByCountryId(int countryid);

    boolean existsById(long id);
}
