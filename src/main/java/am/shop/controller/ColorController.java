package am.shop.controller;


import am.shop.model.Color;
import am.shop.service.ColorService;
import am.shop.util.exceptions.DuplicateException;
import am.shop.util.exceptions.NotFoundExcaption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/color")
public class ColorController {
    @Autowired
    private ColorService colorService;

    //get Color by id
    @GetMapping("/{id}")
    public Color getById(@PathVariable int id) throws NotFoundExcaption {
        return colorService.getById(id);
    }

    //get all colors
    @GetMapping
    public List<Color> getByAll() throws NotFoundExcaption {
        return colorService.getByAll();
    }

    //crate Color
    @PostMapping
    public ResponseEntity<Void> crateColor(@Valid @RequestBody Color color) throws DuplicateException {
        colorService.crateColor(color);
        return ResponseEntity.ok().build();
    }

    //edit Color
    @PatchMapping("edit-color")
    public ResponseEntity<Void> editColor(@Valid @RequestBody Color color) throws DuplicateException {
        colorService.editColor(color);
        return ResponseEntity.ok().build();
    }

}
