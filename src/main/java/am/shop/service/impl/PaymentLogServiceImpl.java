package am.shop.service.impl;

import am.shop.model.PaymentLog;
import am.shop.service.PaymentLogService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentLogServiceImpl implements PaymentLogService {

    @Override
    public PaymentLog getById(int id) {
        return null;
    }

    @Override
    public List<PaymentLog> getByAll() {
        return null;
    }

    @Override
    public void cratePaymentLog(PaymentLog paymentLog) {

    }
}
