package am.shop.model;

import lombok.Data;
import javax.persistence.*;

@Data
@Entity
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    private Country country;

    @ManyToOne
    private State state;

    @ManyToOne
    private City city;

    @Column(name = "zip_code")
    private String zipCode;

    private String address;
}
