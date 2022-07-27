package am.shop.controller;


import am.shop.model.PaymentLog;
import am.shop.service.PaymentLogService;
import am.shop.util.exceptions.BadRequestException;
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

    //get payment by id
    @GetMapping("/{id}")
    public PaymentLog getById(@PathVariable int id) throws NotFoundExcaption {
        return paymentLogService.getById(id);
    }

    //get all payment
    @GetMapping
    public List<PaymentLog> getByAll() throws NotFoundExcaption {
        return paymentLogService.getByAll();
    }

    //payment Items
    @PostMapping("/byItems")
    public ResponseEntity<Void> byItems(@RequestParam long userId) throws   BadRequestException {
        paymentLogService.byItems(userId);
        return ResponseEntity.ok().build();
    }
}
