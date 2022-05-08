package am.shop.model;

import lombok.Data;
import javax.persistence.*;

@Data
@Entity
public class State {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String state;

    @ManyToOne
    private Country country;

}
