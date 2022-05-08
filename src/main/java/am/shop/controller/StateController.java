package am.shop.controller;


import am.shop.model.Country;
import am.shop.model.State;
import am.shop.service.CountryService;
import am.shop.service.StateService;
import am.shop.util.exceptions.DuplicateException;
import am.shop.util.exceptions.NotFoundExcaption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/state")
public class StateController {
    @Autowired
    private StateService stateService;

    @GetMapping("/{id}")
    public State getById(@PathVariable int id) throws NotFoundExcaption {
        return stateService.getById(id);
    }

    @GetMapping
    public List<State> getByAll() throws NotFoundExcaption {
        return stateService.getByAll();
    }

    @PostMapping
    public ResponseEntity<Void> crateState(@RequestBody State state) throws DuplicateException {
        stateService.crateState(state);
        return ResponseEntity.ok().build();
    }

}
