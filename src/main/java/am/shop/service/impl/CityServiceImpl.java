package am.shop.service.impl;


import am.shop.model.City;
import am.shop.repository.CityRepository;
import am.shop.service.CityService;
import am.shop.service.CountryService;
import am.shop.service.StateService;
import am.shop.util.exceptions.DuplicateException;
import am.shop.util.exceptions.NotFoundExcaption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityServiceImpl implements CityService {
    @Autowired
    private CityRepository cityRepository;

    @Autowired
    private StateService stateService;

    @Autowired
    private CountryService countryService;

    @Override
    public City getById(long id) throws NotFoundExcaption {
        City city = cityRepository.findById(id).orElse(null);

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
    public void crateCity(City city) throws DuplicateException,NotFoundExcaption {
        cityCreationChecks(city);
        cityRepository.save(city);
    }

    private void cityCreationChecks(City city) throws DuplicateException, NotFoundExcaption {
        int dupCount = cityRepository.countByCity(city.getCity());

        if (dupCount > 0) {
            throw new DuplicateException("duplication city");
        }
        if( city.getState() != null  ){
            if(stateService.getById(city.getState().getId()) == null) {
                throw new NotFoundExcaption("not found state");
            }
        }
        if(countryService.getById(city.getCountry().getId()) == null){

            throw new NotFoundExcaption("not found country");
        }
    }

    @Override
    public List<City> getByCountryId(int countryid) {
        return cityRepository.getByCountryId(countryid);
    }

    @Override
    public boolean existsById(long id) {
        return cityRepository.existsById(id);
    }

    @Override
    public void editCity(City city) throws NotFoundExcaption, DuplicateException {
        cityCreationChecks(city);
        cityRepository.save(city);
    }
}
