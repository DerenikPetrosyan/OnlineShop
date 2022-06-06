package am.shop.controller;


import am.shop.model.Address;
import am.shop.model.dto.request.EditUserDto;
import am.shop.service.AddressService;
import am.shop.util.exceptions.BadRequestException;
import am.shop.util.exceptions.DuplicateException;
import am.shop.util.exceptions.NotFoundExcaption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/address")
public class AddressController {

    @Autowired
    private AddressService addressService;

    @GetMapping("/{id}")
    public Address getById(@PathVariable int id) throws NotFoundExcaption {
        return addressService.getById(id);
    }

    @GetMapping
    public List<Address> getByAll() throws NotFoundExcaption {
        return addressService.getByAll();
    }

    @PostMapping
    public ResponseEntity<Void> crateAddress(@Valid  @RequestBody Address address) throws DuplicateException, NotFoundExcaption, BadRequestException {
        addressService.crateAddress(address);
        return ResponseEntity.ok().build();
    }
    @PatchMapping("edit-address")
    public ResponseEntity<Void> editAddress(@Valid@RequestBody Address address) throws NotFoundExcaption, BadRequestException {
        addressService.editAddress(address);
        return ResponseEntity.ok().build();
    }
}
