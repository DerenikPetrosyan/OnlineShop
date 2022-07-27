package am.shop.model;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Entity
public class UserBalance {

    @Id
    private long userId;

   /* @MapsId
    @OneToOne
    @JoinColumn(name = "user_id")
    private  User user;*/


    private BigDecimal balance;
}
