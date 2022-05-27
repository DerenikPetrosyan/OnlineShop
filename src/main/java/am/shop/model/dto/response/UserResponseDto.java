package am.shop.model.dto.response;

import am.shop.model.Gender;
import am.shop.model.UserStatus;


import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserResponseDto {

    private long id;

    private String firstName;

    private String lastName;

    private String email;

    private Gender gender;

    private long dob;

    private UserStatus status;

    private long updatedAt;

    private String city;

    private String state;

    private String country;

    private String zipCode;

    private String address;

    public UserResponseDto(long id, String firstName, String lastName, String email, Gender gender,
                           long dob, UserStatus status, long updatedAt, String city, String state,
                           String country, String zipCode, String address) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.gender = gender;
        this.dob = dob;
        this.status = status;
        this.updatedAt = updatedAt;
        this.city = city;
        this.state = state;
        this.country = country;
        this.zipCode = zipCode;
        this.address = address;
    }
}

