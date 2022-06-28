package am.shop.service;

import am.shop.model.Basket;

import java.util.List;

public interface BasketService {
    Basket getById(long id);

    List<Basket> getByAll();

    void crateBasket(Basket basket);
}
