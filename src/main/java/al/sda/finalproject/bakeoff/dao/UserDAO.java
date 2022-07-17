package al.sda.finalproject.bakeoff.dao;

import al.sda.finalproject.bakeoff.dto.UserDTO;

public interface UserDAO extends GenericDAO<UserDTO>{
    UserDTO findUserByUsername(String username);
    UserDTO findUserByEmail(String email);
}
