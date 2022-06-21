package am.shop.service;


import am.shop.model.Category;
import am.shop.util.exceptions.DuplicateException;
import am.shop.util.exceptions.NotFoundExcaption;

import java.util.List;

public interface CategoryService {

    Category  getById(int id) throws NotFoundExcaption;

    List<Category> getByAll() throws NotFoundExcaption;

    void crateCategory(Category category) throws DuplicateException;

    void editCategory(Category category) throws DuplicateException;
}
