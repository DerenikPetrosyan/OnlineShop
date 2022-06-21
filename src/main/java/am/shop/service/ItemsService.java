package am.shop.service;

import am.shop.model.Items;
import am.shop.model.dto.response.ItemsInfoPaser;
import am.shop.util.exceptions.BadRequestException;
import am.shop.util.exceptions.NotFoundExcaption;

import java.math.BigDecimal;
import java.util.List;

public interface ItemsService {
    Items getById(long id) throws NotFoundExcaption;

    List<Items> getByAll() throws NotFoundExcaption;

    void crateItems(Items items) throws BadRequestException;

    void editItems(Items items) throws BadRequestException;

    List<ItemsInfoPaser> search(String name, String brand, String category);

    List<ItemsInfoPaser> priceExpensive(BigDecimal price);

    List<ItemsInfoPaser> priceCheap(BigDecimal price);
}
