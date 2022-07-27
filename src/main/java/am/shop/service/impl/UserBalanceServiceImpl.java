package am.shop.service.impl;

import am.shop.model.UserBalance;
import am.shop.repository.UserBalanceRepository;
import am.shop.service.UserBalanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class UserBalanceServiceImpl implements UserBalanceService {

    @Autowired
    private UserBalanceRepository userBalanceRepository;


    @Override
    public UserBalance getById(long id) {
        return userBalanceRepository.getById(id);
    }

    @Override
    public List<UserBalance> getByAll() {
        return userBalanceRepository.findAll();
    }

    @Override
    public void crateUserBalance(UserBalance userBalance) {
        userBalanceRepository.save(userBalance);
    }

    @Override
    public void subtractUserBalance(long userid, BigDecimal price) {
        UserBalance userBalance = userBalanceRepository.getById(userid);
        BigDecimal balance = userBalance.getBalance();

        balance = balance.subtract(price);

        userBalance.setBalance(balance);
        userBalanceRepository.save(userBalance);


    }
}
