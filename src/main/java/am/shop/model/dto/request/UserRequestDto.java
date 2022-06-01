package am.shop.model.dto.request;

import am.shop.model.Address;
import am.shop.model.Gender;
import lombok.Data;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


@Data
public class UserRequestDto {

    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;

    @NotBlank
    private String email;

    @NotNull
    private Gender gender;

    private long dob;

    @NotBlank
    private String password;

    @NotBlank
    private String confirmPassword;

    @NotNull
    private Address address;




}
