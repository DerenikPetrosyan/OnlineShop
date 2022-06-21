package am.shop.service.impl;

import am.shop.model.Items;
import am.shop.model.dto.response.ItemsInfoPaser;
import am.shop.repository.ItemsRepository;
import am.shop.service.ItemsService;
import am.shop.util.exceptions.BadRequestException;
import am.shop.util.exceptions.NotFoundExcaption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class ItemsServiceImpl implements ItemsService {

    @Autowired
    private ItemsRepository itemsRepository;

    @Override
    public Items getById(long id) throws NotFoundExcaption {
        return itemsRepository.getById(id);
    }

    @Override
    public List<Items> getByAll() throws NotFoundExcaption {
        return itemsRepository.findAll();
    }

    @Override
    public void crateItems(Items items) throws BadRequestException {
        itemsCreationChecks(items);
        itemsRepository.save(items);
    }

    private void itemsCreationChecks(Items items) throws BadRequestException {
        if (items.getPrice().signum() <= 0) {
            throw new BadRequestException("You must enter a positive number in the prise  field");
        }
        else if(items.getCount()<=0){
            throw new BadRequestException("You must enter a positive number in the count field");
        }


    }

    @Override
    public void editItems(Items items) throws BadRequestException {
    itemsCreationChecks(items);
    itemsRepository.save(items);
    }

    @Override
    public List<ItemsInfoPaser> search(String name, String brand, String category) {
        return itemsRepository.search(name,brand,category);
    }

    @Override
    public List<ItemsInfoPaser> priceExpensive(BigDecimal price) {
        return itemsRepository.priceExpensive(price);
    }

    @Override
    public List<ItemsInfoPaser> priceCheap(BigDecimal price) {
        return itemsRepository.priceCheap(price);
    }
}
