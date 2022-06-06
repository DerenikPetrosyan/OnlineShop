package am.shop.controller;


import am.shop.model.Category;
import am.shop.service.CategoryService;
import am.shop.util.exceptions.NotFoundExcaption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/{id}")
    public Category getById(@PathVariable int id) throws NotFoundExcaption {
        return categoryService.getById(id);
    }

    @GetMapping
    public List<Category> getByAll() throws NotFoundExcaption {
        return categoryService.getByAll();
    }

    @PostMapping
    public ResponseEntity<Void> crateCategory(@Valid @RequestBody Category category)  {
        categoryService.crateCategory(category);
        return ResponseEntity.ok().build();
    }
    @PatchMapping("edit-category")
    public ResponseEntity<Void> editCategory(@Valid@RequestBody Category category)  {
        categoryService.editCategory(category);
        return ResponseEntity.ok().build();
    }


}
