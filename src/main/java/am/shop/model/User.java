package am.shop.model;

import lombok.Data;
import javax.persistence.*;
import java.util.Set;


@Data
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    private String email;

    @Enumerated(value = EnumType.STRING)
    private Gender gender;

    private long dob;//date of birthday

    private String password;

    @Enumerated(value = EnumType.STRING)
    private UserStatus status;

    @Column(name = "ver_code")
    private String verCode;

    @Column(name = "updated_at")
    private long updatedAt;

    @Column(name = "reset_password_token")
    private String resetPasswordToken;

    @OneToOne(cascade = CascadeType.ALL)
    private Address address;

    @ManyToMany
    @JoinTable(name = "user_role",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
    private Set<Role> roles;


}
