package am.shop.service;

import am.shop.model.PaymentLog;

import java.util.List;

public interface PaymentLogService {
    PaymentLog getById(int id);

    List<PaymentLog> getByAll();

    void cratePaymentLog(PaymentLog paymentLog);
}
