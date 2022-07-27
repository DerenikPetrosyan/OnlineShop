package am.shop.service;

import am.shop.model.PaymentLog;
import am.shop.util.exceptions.BadRequestException;

import java.util.List;

public interface PaymentLogService {
    PaymentLog getById(long id);

    List<PaymentLog> getByAll();

    void byItems(long userId) throws BadRequestException;
}
