package am.shop.model.dto.request;

import am.shop.model.Gender;
import lombok.Data;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

import java.io.Serializable;

/**
 * Class used to send a request to create a user
 */
@Data
public class UserRequestDto implements Serializable{

    private static final long serialVersionUID = -7474838713815803531L;

    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;

    @NotBlank
    private String email;

    @NotNull
    private Gender gender;

    private Date dob;

    @NotBlank
    private String password;

    @NotBlank
    private String confirmPassword;


}
