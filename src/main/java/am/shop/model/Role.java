package am.shop.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Enumerated(value = EnumType.STRING)
    private UserRoles role;
}
