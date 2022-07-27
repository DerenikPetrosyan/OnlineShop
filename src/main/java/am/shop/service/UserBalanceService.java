package am.shop.service;

import am.shop.model.UserBalance;

import java.math.BigDecimal;
import java.util.List;

public interface UserBalanceService {
    UserBalance getById(long id);

    List<UserBalance> getByAll();

    void crateUserBalance(UserBalance userBalance);

    void subtractUserBalance(long userId,BigDecimal price);
}
