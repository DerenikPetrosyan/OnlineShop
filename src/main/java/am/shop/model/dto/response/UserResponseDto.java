package am.shop.model.dto.response;


import am.shop.model.*;
import lombok.Data;
import java.util.Set;

@Data
public class UserResponseDto {

    private String firstName;

    private String lastName;

    private String email;

    private Gender gender;

    private long dob;

    private Address address;

    private UserStatus status;

    private Set<Role> roles;

    public UserResponseDto(User user) {
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        this.email = user.getEmail();
        this.gender = user.getGender();
        this.dob = user.getDob();
        this.address = user.getAddress();
        this.status = user.getStatus();
        this.roles = user.getRoles();

    }
}
