package am.shop.service;

import am.shop.model.UserBalance;

import java.util.List;

public interface UserBalanceService {
    UserBalance getById(int id);

    List<UserBalance> getByAll();

    void crateUserBalance(UserBalance userBalance);
}
