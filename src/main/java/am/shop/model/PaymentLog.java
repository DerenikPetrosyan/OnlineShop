package am.shop.model;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Entity
public class PaymentLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

   /* @ManyToOne
    @JoinColumn(name = "user_id")
    private  User user;*/

    private long userId;

    private BigDecimal amount;

    private long cratedAt;

}
