package am.shop.model;

import javax.persistence.*;

public class UserItems {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private  User user;

    @ManyToOne
    @JoinColumn(name = "item_id")
    private  Items items;

    @ManyToOne
    @JoinColumn(name = "color_id")
    private  Color color;

    private long cratedAt;
}
