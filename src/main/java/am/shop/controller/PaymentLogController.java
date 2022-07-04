package am.shop.controller;


import am.shop.model.PaymentLog;
import am.shop.service.PaymentLogService;
import am.shop.util.exceptions.DuplicateException;
import am.shop.util.exceptions.NotFoundExcaption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/payment_log")
public class PaymentLogController {

    @Autowired
    private PaymentLogService paymentLogService;

    @GetMapping("/{id}")
    public PaymentLog getById(@PathVariable int id) throws NotFoundExcaption {
        return paymentLogService.getById(id);
    }

    @GetMapping
    public List<PaymentLog> getByAll() throws NotFoundExcaption {
        return paymentLogService.getByAll();
    }

    @PostMapping
    public ResponseEntity<Void> cratePaymentLog(@Valid @RequestBody PaymentLog paymentLog) throws DuplicateException {
        paymentLogService.cratePaymentLog(paymentLog);
        return ResponseEntity.ok().build();
    }
}
