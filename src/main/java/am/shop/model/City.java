package am.shop.model;

import lombok.Data;
import javax.persistence.*;

@Data
@Entity
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String city;

    @ManyToOne
    private State state;

    @ManyToOne
    private Country country;

}
