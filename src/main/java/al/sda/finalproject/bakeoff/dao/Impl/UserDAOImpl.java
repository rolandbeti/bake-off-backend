package al.sda.finalproject.bakeoff.dao.Impl;

import al.sda.finalproject.bakeoff.dao.UserDAO;
import al.sda.finalproject.bakeoff.dto.UserDTO;
import al.sda.finalproject.bakeoff.entity.UserEntity;
import al.sda.finalproject.bakeoff.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Optional;
@Component
public class UserDAOImpl implements UserDAO {

    private final UserRepository userRepository;
    @Autowired
    public UserDAOImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public List<UserDTO> findAll() {
        return this.userRepository.findAll().stream().map(UserDAOImpl::mapToDTO).toList();
    }

    @Override
    public UserDTO findById(Long id) {
        Optional<UserEntity>userEntity = this.userRepository.findById(id);
        return userEntity.map(UserDAOImpl::mapToDTO).orElse(null);
    }

    @Override
    public void save(UserDTO userDTO) {
        this.userRepository.save(UserDAOImpl.mapToEntity(userDTO));
    }

    @Override
    public void deleteById(Long id) {
        this.userRepository.deleteById(id);
    }

    @Override
    public UserDTO findUserByUsername(String username) {
        return UserDAOImpl.mapToDTO(this.userRepository.findUserEntityByUsername(username));
    }

    @Override
    public UserDTO findUserByEmail(String email) {
        return UserDAOImpl.mapToDTO(this.userRepository.findUserEntityByEmail(email));
    }

    public static UserEntity mapToEntity(UserDTO userDTO){
        UserEntity userEntity = new UserEntity();
        userEntity.setUserId(userDTO.getUserId());
        userEntity.setAddress(AddressDAOImpl.mapToEntity(userDTO.getAddress()));
        userEntity.setEmail(userDTO.getEmail());
        userEntity.setPassword(userDTO.getPassword());
        userEntity.setFirstName(userDTO.getFirstName());
        userEntity.setLastName(userDTO.getLastName());
        userEntity.setId(userDTO.getId());
        userEntity.setRole(RoleDAOImpl.mapToEntity(userDTO.getRole()));
        userEntity.setUsername(userDTO.getUsername());
        return userEntity;
    }

    public static UserDTO mapToDTO(UserEntity userEntity){
        UserDTO userDTO = new UserDTO();
        userDTO.setUserId(userEntity.getUserId());
        userDTO.setId(userEntity.getId());
        userDTO.setFirstName(userEntity.getFirstName());
        userDTO.setLastName(userEntity.getLastName());
        userDTO.setEmail(userEntity.getEmail());
        userDTO.setUsername(userEntity.getUsername());
        userDTO.setPassword(userEntity.getPassword());
        userDTO.setAddress(AddressDAOImpl.mapToDTO(userEntity.getAddress()));
        userDTO.setRole(RoleDAOImpl.mapToDTO(userEntity.getRole()));
        return userDTO;
    }
}
