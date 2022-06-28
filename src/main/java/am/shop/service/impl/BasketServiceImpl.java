package am.shop.service.impl;

import am.shop.model.Basket;
import am.shop.repository.BasketRepository;
import am.shop.service.BasketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BasketServiceImpl implements BasketService {

    @Autowired
    BasketRepository basketRepository;


    @Override
    public Basket getById(long id) {
        return basketRepository.getById(id);
    }

    @Override
    public List<Basket> getByAll() {
        return basketRepository.findAll();
    }

    @Override
    public void crateBasket(Basket basket) {
        basketRepository.save(basket);
    }
}
