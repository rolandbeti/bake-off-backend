package al.sda.finalproject.bakeoff.service.impl;

import al.sda.finalproject.bakeoff.dao.RoleDAO;
import al.sda.finalproject.bakeoff.dao.UserDAO;
import al.sda.finalproject.bakeoff.dto.UserDTO;
import al.sda.finalproject.bakeoff.exception.EmailExistException;
import al.sda.finalproject.bakeoff.exception.UsernameExistException;
import al.sda.finalproject.bakeoff.service.UserService;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class UserServiceImpl implements UserService {
    private final UserDAO userDAO;
    private final PasswordEncoder passwordEncoder;
    private final RoleDAO roleDAO;

    @Autowired
    public UserServiceImpl(UserDAO userDAO, PasswordEncoder passwordEncoder, RoleDAO roleDAO){
        this.userDAO = userDAO;
        this.passwordEncoder = passwordEncoder;
        this.roleDAO = roleDAO;
    }

    @Override
    public List<UserDTO> findAll() {
        return this.userDAO.findAll();
    }

    @Override
    public UserDTO findById(Long id) {
        return this.userDAO.findById(id);
    }

    @Override
    public void save(UserDTO userDTO) {
        this.userDAO.save(userDTO);
    }

    @Override
    public void deleteById(Long id) {
        this.userDAO.deleteById(id);
    }

    @Override
    public UserDTO findUserByUsername(String username) {
        return this.userDAO.findUserByUsername(username);
    }

    @Override
    public UserDTO findUserByEmail(String email) {
        return this.userDAO.findUserByEmail(email);
    }

    @Override
    public UserDTO add(UserDTO userDTO) {
        String password = null;
        try{
            validateUsernameEmail(userDTO.getUsername(), userDTO.getEmail());
        } catch (Exception e){
            e.printStackTrace();
        }
        UserDTO userToSave = new UserDTO();
        if (userDTO.getPassword() == null){
            password = generatedPassword();
        } else{
            password = userDTO.getPassword();
        }
        userToSave.setUserId(generatedUserId());
        userToSave.setRole(this.roleDAO.findById(2L));
        userToSave.setAddress(userDTO.getAddress());
        userToSave.setPassword(encryptedPassword(password));
        userToSave.setUsername(userDTO.getUsername());
        userToSave.setEmail(userDTO.getEmail());
        userToSave.setFirstName(userDTO.getFirstName());
        userToSave.setLastName(userDTO.getLastName());
        this.userDAO.save(userToSave);
        return this.userDAO.findUserByUsername(userToSave.getUsername());
    }

    private void validateUsernameEmail(String username, String email) throws UsernameExistException, EmailExistException {
        if (this.userDAO.findUserByUsername(username) != null){
            throw new UsernameExistException("Username already exist");
        }
        if (this.userDAO.findUserByEmail(email) != null){
            throw new EmailExistException("Email already exist");
        }
    }

    private String encryptedPassword(String password) {
        return passwordEncoder.encode(password);
    }

    private String generatedUserId() {
        return RandomStringUtils.randomNumeric(10);
    }

    private String generatedPassword() {
        return RandomStringUtils.randomAlphanumeric(10);
    }
}
