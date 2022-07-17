package al.sda.finalproject.bakeoff.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AccountDTO {
    private Long id;
    private String username;
    private String password;
    private RoleDTO role;
}
