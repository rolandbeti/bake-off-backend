package al.sda.finalproject.bakeoff.dto;

import al.sda.finalproject.bakeoff.entity.AccountEntity;
import al.sda.finalproject.bakeoff.entity.AddressEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private AddressDTO address;
    private String email;
    private AccountDTO account;
}
