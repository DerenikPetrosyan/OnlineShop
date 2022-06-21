package am.shop.model.dto.response;

import am.shop.model.Gender;
import am.shop.model.UserStatus;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
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

}

