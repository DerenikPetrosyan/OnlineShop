package am.shop.controller;


import am.shop.model.City;
import am.shop.service.CityService;
import am.shop.util.exceptions.DuplicateException;
import am.shop.util.exceptions.NotFoundExcaption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    public ResponseEntity<Void> crateState(@RequestBody City city) throws DuplicateException {
        cityService.crateCity(city);
        return ResponseEntity.ok().build();
    }

}
