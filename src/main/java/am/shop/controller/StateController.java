package am.shop.controller;

import am.shop.model.State;
import am.shop.service.StateService;
import am.shop.util.exceptions.DuplicateException;
import am.shop.util.exceptions.NotFoundExcaption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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

    @GetMapping("/country/{countryid}")
    public ResponseEntity<List<State>> getByCountryId(@PathVariable int countryid){
        return ResponseEntity.ok(stateService.getByCountryId(countryid));
    }

    @PostMapping
    public ResponseEntity<Void> crateState(@Valid @RequestBody State state) throws DuplicateException, NotFoundExcaption {
        stateService.crateState(state);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/edit-state")
    public ResponseEntity<Void> editState(@Valid@RequestBody State state) throws NotFoundExcaption, DuplicateException {
        stateService.editState(state);
        return ResponseEntity.ok().build();
    }


}
