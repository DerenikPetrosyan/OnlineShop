package am.shop.model.dto.request;

import am.shop.model.Gender;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

/**
 * class, with the help of which we change the attributes shown below,
 * reducing the volume of the sent request
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EditUserDto {
    @NotNull
    private long id;

    private String firstName;

    private String lastName;

    private Gender gender;

    private long dob;
}
