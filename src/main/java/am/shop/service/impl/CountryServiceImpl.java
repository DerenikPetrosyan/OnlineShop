package am.shop.service.impl;

import am.shop.model.Country;
import am.shop.repository.CountryRepository;
import am.shop.service.CountryService;
import am.shop.util.exceptions.DuplicateException;
import am.shop.util.exceptions.NotFoundExcaption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryServiceImpl implements CountryService {
    @Autowired
    private CountryRepository countryRepository;

    @Override
    public Country getById(int id) throws NotFoundExcaption {
        Country country = countryRepository.getById(id);
        if (country == null) {
            throw new NotFoundExcaption();
        }
        return country;
    }

    @Override
    public List<Country> getByAll() throws NotFoundExcaption {

        return countryRepository.findAll();
    }

    @Override
    public void crateCountry(Country country) throws DuplicateException {
        countryCreationChecks(country);
        countryRepository.save(country);
    }

    private void countryCreationChecks(Country country) throws DuplicateException {

        int dupCount = countryRepository.countByCountry(country.getCountry());
        if (dupCount > 0) {
            throw new DuplicateException("duplication country");
        }
    }

    @Override
    public boolean existsById(int id){
        return countryRepository.existsById(id);
    }

}
