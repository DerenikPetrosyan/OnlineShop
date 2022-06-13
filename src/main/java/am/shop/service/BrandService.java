package am.shop.service;

import am.shop.model.Brand;
import am.shop.util.exceptions.BadRequestException;
import am.shop.util.exceptions.NotFoundExcaption;

import java.util.List;

public interface BrandService {

    Brand getById(int id) throws NotFoundExcaption;

    List<Brand> getByAll() throws NotFoundExcaption;

    void crateBrand(Brand brand) throws BadRequestException;

    void editBrand(Brand brand) throws NotFoundExcaption, BadRequestException;
    
}
