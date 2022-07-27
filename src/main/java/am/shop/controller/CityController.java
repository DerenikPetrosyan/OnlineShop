package am.shop.controller;


import am.shop.model.City;
import am.shop.service.CityService;
import am.shop.util.exceptions.DuplicateException;
import am.shop.util.exceptions.NotFoundExcaption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/city")
public class CityController {

    @Autowired
    private CityService cityService;

    //get city by id
    @GetMapping("/{id}")
    public City getById(@PathVariable int id) throws NotFoundExcaption {
        return cityService.getById(id);
    }

    //get all city
    @GetMapping
    public List<City> getByAll() throws NotFoundExcaption {
        return cityService.getByAll();
    }

    //get Cities where
    @GetMapping("/country/{countryid}")
    public ResponseEntity<List<City>> getByCountryId(@PathVariable int countryid){
        return ResponseEntity.ok(cityService.getByCountryId(countryid));
    }


    // crate City
    @PostMapping
    public ResponseEntity<Void> crateCity(@Valid @RequestBody City city) throws DuplicateException, NotFoundExcaption {
        cityService.crateCity(city);
        return ResponseEntity.ok().build();
    }


    //edit City
    @PatchMapping("edit-city")
    public ResponseEntity<Void> editCity(@Valid@RequestBody City city) throws DuplicateException, NotFoundExcaption {
        cityService.editCity(city);
        return ResponseEntity.ok().build();
    }

}
