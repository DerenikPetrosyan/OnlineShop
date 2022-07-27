package am.shop.service;

import am.shop.model.UserItems;

import java.util.List;

public interface UserItemsService {
    UserItems getById(long id);

    List<UserItems> getByAll();

    void crateUserItems(UserItems userItems);
}
