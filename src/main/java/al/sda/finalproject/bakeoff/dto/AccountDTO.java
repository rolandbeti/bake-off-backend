package al.sda.finalproject.bakeoff.dto;

import al.sda.finalproject.bakeoff.entity.RoleEntity;
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
