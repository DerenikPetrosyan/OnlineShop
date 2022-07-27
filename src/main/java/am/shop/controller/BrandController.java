package am.shop.controller;

import am.shop.model.Brand;
import am.shop.service.BrandService;
import am.shop.util.exceptions.BadRequestException;
import am.shop.util.exceptions.NotFoundExcaption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/brand")
public class BrandController {

    @Autowired
    private BrandService brandService;

    //get brand by id
    @GetMapping("/{id}")
    public Brand getById(@PathVariable int id) throws NotFoundExcaption {
        return brandService.getById(id);
    }

    //get all brand
    @GetMapping
    public List<Brand> getByAll() throws NotFoundExcaption {
        return brandService.getByAll();
    }

    //crate new brand
    @PostMapping
    public ResponseEntity<Void> crateBrand(@Valid @RequestBody Brand brand) throws  BadRequestException {
        brandService.crateBrand(brand);
        return ResponseEntity.ok().build();
    }

    //edit brand
    @PatchMapping("edit-brand")
    public ResponseEntity<Void> editBrand(@Valid@RequestBody Brand brand) throws NotFoundExcaption, BadRequestException {
        brandService.editBrand(brand);
        return ResponseEntity.ok().build();
    }

}
