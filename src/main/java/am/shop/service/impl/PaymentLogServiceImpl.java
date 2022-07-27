package am.shop.service.impl;

import am.shop.model.Basket;
import am.shop.model.PaymentLog;
import am.shop.model.UserItems;
import am.shop.repository.PaymentLogRepository;
import am.shop.service.*;
import am.shop.util.exceptions.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
public class PaymentLogServiceImpl implements PaymentLogService {

    @Autowired
    private PaymentLogRepository paymentLogRepository;

    @Autowired
    private BasketService basketService;

    @Autowired
    private UserBalanceService userBalanceService;

    @Autowired
    private ItemsService itemsService;

    @Autowired
    private UserItemsService userItemsService;

    private BigDecimal balance_1;

    //get payment by id
    @Override
    public PaymentLog getById(long id) {
        return paymentLogRepository.getById(id);
    }

    //get all payment
    @Override
    public List<PaymentLog> getByAll() {
        return paymentLogRepository.findAll();
    }


    //by items
    @Override
    @Transactional
    public void byItems(long userId) throws BadRequestException {

        balance_1 = BigDecimal.ZERO;

        //get all items at basket
        List<Basket> userItems = basketService.getByUserItems(userId);

        //how much money is needed for the purchase?
        userItems.forEach(
                (n) ->
                        balance_1 = balance_1.add(
                                n.getItems().getPrice().multiply
                                        (new BigDecimal(basketService.getByCount(n.getId())))));

        //balance is sufficient for the purchase
        if ((balance_1.compareTo(userBalanceService.getById(userId).getBalance()) > 0)) {
            throw new BadRequestException("Not enough money to make a purchase, check your balance");
        }

        //the cost of purchased goods is deducted from the balance
        userBalanceService.subtractUserBalance(userId, balance_1);

        // Subtracting all purchased items from total count of things
        userItems.forEach((i) -> itemsService.subtractCountItems(i.getItems().getId(), i.getCount()));

        //items add to user_items
        userItems.forEach((i) ->
                userItemsService.crateUserItems(
                        new UserItems(0, i.getUser(), i.getItems(), i.getColor(), i.getCount(), 0)));

        PaymentLog paymentLog = new PaymentLog();
        paymentLog.setUserId(userId);
        paymentLog.setAmount(balance_1);
        paymentLog.setCratedAt(System.currentTimeMillis());


        //save to DB from payment_log in table
        paymentLogRepository.save(paymentLog);
    }
}
