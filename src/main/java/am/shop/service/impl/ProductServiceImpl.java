package am.shop.service.impl;

import am.shop.model.Product;
import am.shop.repository.ProductRepository;
import am.shop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Override
    public void createProduct(Product product) {
        productRepository.save(product);
    }

    @Override
    public List<Product> getType(String type) {
        return productRepository.getByType(type);
    }
}
