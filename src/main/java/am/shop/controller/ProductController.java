package am.shop.controller;


import am.shop.model.Product;
import am.shop.model.dto.response.UserResponseDto;
import am.shop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @PostMapping
    public ResponseEntity<Void> crateProduct(@Valid @RequestBody Product product){
        productService.createProduct(product);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{type}")
    public ResponseEntity<List<Product>> getType(@PathVariable String type) {
        return ResponseEntity.ok(productService.getType(type));
    }
}
