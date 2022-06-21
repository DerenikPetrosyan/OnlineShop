package am.shop.model.dto.request;

import am.shop.model.Gender;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

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
