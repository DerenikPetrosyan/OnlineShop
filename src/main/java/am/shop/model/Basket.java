package am.shop.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Basket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "items_id")
    private Items items;

    @ManyToOne
    @JoinColumn(name = "color_id")
    private Color color;
}
