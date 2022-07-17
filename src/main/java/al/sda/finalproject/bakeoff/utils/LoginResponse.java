package al.sda.finalproject.bakeoff.utils;

import al.sda.finalproject.bakeoff.entity.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class LoginResponse {
    private UserEntity user;
    private String token;

}
