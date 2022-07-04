package am.shop.controller;

import am.shop.model.UserBalance;
import am.shop.service.UserBalanceService;
import am.shop.util.exceptions.DuplicateException;
import am.shop.util.exceptions.NotFoundExcaption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/user_balance")
public class UserBalanceController {

    @Autowired
    private UserBalanceService userBalanceService;

    @GetMapping("/{id}")
    public UserBalance getById(@PathVariable int id) throws NotFoundExcaption {
        return userBalanceService.getById(id);
    }

    @GetMapping
    public List<UserBalance> getByAll() throws NotFoundExcaption {
        return userBalanceService.getByAll();
    }

    @PostMapping
    public ResponseEntity<Void> crateUserBalance(@Valid @RequestBody UserBalance userBalance) throws DuplicateException {
        userBalanceService.crateUserBalance(userBalance);
        return ResponseEntity.ok().build();
    }
}
