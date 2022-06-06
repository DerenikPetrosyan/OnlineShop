package am.shop.service.impl;

import am.shop.model.Category;
import am.shop.repository.CategoryRepository;
import am.shop.service.CategoryService;
import am.shop.util.exceptions.BadRequestException;
import am.shop.util.exceptions.NotFoundExcaption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Category getById(int id) throws NotFoundExcaption {
        return categoryRepository.getById(id);
    }

    @Override
    public List<Category> getByAll() throws NotFoundExcaption {
        return categoryRepository.findAll();
    }

    @Override
    public void crateCategory(Category category){
        categoryRepository.save(category);
    }

    @Override
    public void editCategory(Category category){
        categoryRepository.save(category);
    }
}
