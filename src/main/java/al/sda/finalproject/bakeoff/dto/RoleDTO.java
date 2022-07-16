package al.sda.finalproject.bakeoff.dto;

import al.sda.finalproject.bakeoff.entity.AuthorityEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RoleDTO {

    private Long id;
    private String roleName;
    private List<AuthorityDTO> authorities;
}
