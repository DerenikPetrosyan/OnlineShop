package am.shop.model.dto.request;

import am.shop.model.Gender;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
public class EditUserDto {

    @NotNull
    private long id;

    private String firstName;

    private String lastName;

    private Gender gender;

    private long dob;


    public EditUserDto(long id, String firstName, String lastName, Gender gender, long dob) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.dob = dob;
    }
}
