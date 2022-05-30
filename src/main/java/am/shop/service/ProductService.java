package am.shop.service;

import am.shop.model.Product;

import java.util.List;

public interface ProductService {

    void createProduct(Product product);

    List<Product> getType(String type);
}
