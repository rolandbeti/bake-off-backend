package al.sda.finalproject.bakeoff.service;

import al.sda.finalproject.bakeoff.dto.UserDTO;

public interface UserService extends GenericService<UserDTO>{
    UserDTO findUserByUsername(String username);
    UserDTO findUserByEmail(String email);

    UserDTO add(UserDTO userDTO);
}
