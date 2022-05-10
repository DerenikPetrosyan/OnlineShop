package am.shop.service.impl;


import am.shop.model.City;
import am.shop.repository.CityRepository;
import am.shop.service.CityService;
import am.shop.util.exceptions.DuplicateException;
import am.shop.util.exceptions.NotFoundExcaption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityServiceImpl implements CityService {
    @Autowired
    private CityRepository cityRepository;

    @Override
    public City getById(int id) throws NotFoundExcaption {
        City city = cityRepository.getById(id);
        if (city == null) {
            throw new NotFoundExcaption();
        }
        return city;
    }

    @Override
    public List<City> getByAll() throws NotFoundExcaption {

        return cityRepository.findAll();
    }

    @Override
    public void crateCity(City city) throws DuplicateException {
        int dupCount = cityRepository.countByCity(city.getCity());
        if (dupCount > 0) {
            throw new DuplicateException("duplication city");
        }
        cityRepository.save(city);
    }
}
