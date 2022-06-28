package am.shop.controller;

import am.shop.model.Basket;
import am.shop.service.BasketService;
import am.shop.util.exceptions.NotFoundExcaption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/basket")
public class BasketController {

    @Autowired
    private BasketService basketService;

    @GetMapping("/{id}")
    public Basket getById(@PathVariable long id) throws NotFoundExcaption {
        return basketService.getById(id);
    }

    @GetMapping
    public List<Basket> getByAll() throws NotFoundExcaption {
        return basketService.getByAll();
    }

    @PostMapping
    public ResponseEntity<Void> crateBasket(@Valid @RequestBody Basket basket) {
        basketService.crateBasket(basket);
        return ResponseEntity.ok().build();
    }
}
