package am.shop.model;

import lombok.Data;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;

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

    @NotBlank
    @Column(name = "zip_code")
    private String zipCode;

    @NotBlank
    private String address;
}
