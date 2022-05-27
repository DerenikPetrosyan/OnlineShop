package am.shop.model.dto.request;

import am.shop.model.Address;
import am.shop.model.Gender;
import lombok.Data;

import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Data
public class EditUserDto {

    @NotNull
    private long id;

    private String firstName;

    private String lastName;

    private Gender gender;

    private long dob;

    @ManyToOne
    private Address address;


}
