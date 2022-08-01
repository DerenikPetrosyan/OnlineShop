package am.shop.model.dto.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * A class used to send a request to reset the password
 */
@Data
public class ResetPasswordDto {

    @NotBlank
    private String email;

    @NotBlank
    private String token;

    @NotBlank
    private String newPassword;

    @NotBlank
    private String confirmPassword;
}
