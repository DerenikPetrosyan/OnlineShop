package am.shop.service.impl;

import am.shop.model.Brand;
import am.shop.repository.BrandRepository;
import am.shop.service.BrandService;
import am.shop.service.CountryService;
import am.shop.util.exceptions.BadRequestException;
import am.shop.util.exceptions.NotFoundExcaption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandServiceImpl implements BrandService {
    @Autowired
    private BrandRepository brandRepository;

    @Autowired
    CountryService countryService;

    @Override
    public Brand getById(int id) throws NotFoundExcaption {
        return brandRepository.getById(id);
    }

    @Override
    public List<Brand> getByAll() throws NotFoundExcaption {
        return brandRepository.findAll();
    }

    @Override
    public void crateBrand(Brand brand) throws  BadRequestException {
        if(!countryService.existsById(brand.getCountry().getId())){
            throw new BadRequestException();
        }
        brandRepository.save(brand);
    }

    @Override
    public void editBrand(Brand brand) throws BadRequestException {
        if(!countryService.existsById(brand.getCountry().getId())){
            throw new BadRequestException();
        }
        else if(brandRepository.existsByBrandName(brand.getBrandName())){
            throw new BadRequestException();
        }
        brandRepository.save(brand);

    }
}

