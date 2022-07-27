package am.shop.service.impl;

import am.shop.model.UserItems;
import am.shop.repository.UserItemsRepository;
import am.shop.service.UserItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserItemsServiceImpl implements UserItemsService {

    @Autowired
    private UserItemsRepository userItemsRepository;


    @Override
    public UserItems getById(long id) {
        return userItemsRepository.getById(id);
    }

    @Override
    public List<UserItems> getByAll() {
        return userItemsRepository.findAll();
    }

    @Override
    public void crateUserItems(UserItems userItems) {
        userItems.setCratedAt(System.currentTimeMillis());
        userItemsRepository.save(userItems);

    }


}
