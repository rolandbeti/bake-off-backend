package al.sda.finalproject.bakeoff.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
public class UserDTO {
    private Long id;

    private String userId;

    private String firstName;

    private String lastName;

    private String email;

    private AddressDTO address;

    private RoleDTO role;

    private String password;

    private String username;
}
