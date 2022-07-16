package al.sda.finalproject.bakeoff.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

public class AddressDTO {
    private Long id;
    private String country;
    private String city;
    private String street;
    private String postalCode;
}
