package am.shop.service;

import am.shop.model.City;
import am.shop.util.exceptions.DuplicateException;
import am.shop.util.exceptions.NotFoundExcaption;

import java.util.List;

public interface CityService {


    City getById(int id) throws NotFoundExcaption;

    List<City> getByAll() throws NotFoundExcaption;

    void crateCity(City city) throws DuplicateException;
}
