package am.shop.model;


import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;
import java.util.Set;

@Data
@Entity
public class Items {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank
    private String name;

    private BigDecimal price;

    private String dsc;

    private int count;

    private long createdAt;

    @ManyToOne
    private Brand brand;

    @ManyToOne
    private Category category;

    @ManyToMany
    @JoinTable(name = "item_color",
            joinColumns = @JoinColumn(name = "item_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "color_id", referencedColumnName = "id"))
    private Set<Color> colors;






}
