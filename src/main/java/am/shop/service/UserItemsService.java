package am.shop.service;

import am.shop.model.UserItems;

import java.util.List;

public interface UserItemsService {
    UserItems getById(int id);

    List<UserItems> getByAll();

    void crateUserItems(UserItems userItems);
}
