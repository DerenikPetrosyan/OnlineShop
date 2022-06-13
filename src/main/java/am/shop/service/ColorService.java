package am.shop.service;

import am.shop.model.Color;
import am.shop.util.exceptions.DuplicateException;
import am.shop.util.exceptions.NotFoundExcaption;

import java.util.List;

public interface ColorService {

    Color getById(int id) throws NotFoundExcaption;

    List<Color> getByAll() throws NotFoundExcaption;

    void crateColor(Color color) throws DuplicateException;

    void editColor(Color color) throws DuplicateException;
}
