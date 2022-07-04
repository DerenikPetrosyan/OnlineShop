package am.shop.controller;


import am.shop.model.UserItems;
import am.shop.service.UserItemsService;
import am.shop.util.exceptions.DuplicateException;
import am.shop.util.exceptions.NotFoundExcaption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/user_items")
public class UserItemsController {

    @Autowired
    private UserItemsService userItemsService;

    @GetMapping("/{id}")
    public UserItems getById(@PathVariable int id) throws NotFoundExcaption {
        return userItemsService.getById(id);
    }

    @GetMapping
    public List<UserItems> getByAll() throws NotFoundExcaption {
        return userItemsService.getByAll();
    }

    @PostMapping
    public ResponseEntity<Void> crateUserItems(@Valid @RequestBody UserItems userItems) throws DuplicateException {
       userItemsService.crateUserItems(userItems);
        return ResponseEntity.ok().build();
    }
}
