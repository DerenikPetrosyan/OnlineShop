package am.shop.controller;

import am.shop.model.Country;
import am.shop.service.CountryService;
import am.shop.util.exceptions.DuplicateException;
import am.shop.util.exceptions.NotFoundExcaption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/country")
public class CountryController {

    @Autowired
    private CountryService countryService;

    @GetMapping("/{id}")
    public Country getById(@PathVariable int id) throws NotFoundExcaption {
        return countryService.getById(id);
    }

    @GetMapping
    public List<Country> getByAll() throws NotFoundExcaption {
        return countryService.getByAll();
    }

    @PostMapping
    public ResponseEntity<Void> crateCountry(@RequestBody Country country) throws DuplicateException {
        countryService.crateCountry(country);
        return ResponseEntity.ok().build();
    }
}
