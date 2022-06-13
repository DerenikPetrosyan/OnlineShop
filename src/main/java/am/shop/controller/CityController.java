package am.shop.controller;


import am.shop.model.City;
import am.shop.model.Color;
import am.shop.model.State;
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

    @GetMapping("/{id}")
    public City getById(@PathVariable int id) throws NotFoundExcaption {
        return cityService.getById(id);
    }

    @GetMapping
    public List<City> getByAll() throws NotFoundExcaption {
        return cityService.getByAll();
    }

    @GetMapping("/country/{countryid}")
    public ResponseEntity<List<City>> getByCountryId(@PathVariable int countryid){
        return ResponseEntity.ok(cityService.getByCountryId(countryid));
    }



    @PostMapping
    public ResponseEntity<Void> crateState(@Valid @RequestBody City city) throws DuplicateException, NotFoundExcaption {
        cityService.crateCity(city);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("edit-city")
    public ResponseEntity<Void> editCity(@Valid@RequestBody City city) throws DuplicateException, NotFoundExcaption {
        cityService.editCity(city);
        return ResponseEntity.ok().build();
    }

}
