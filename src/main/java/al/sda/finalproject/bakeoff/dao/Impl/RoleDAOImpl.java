package al.sda.finalproject.bakeoff.dao.Impl;

import al.sda.finalproject.bakeoff.dao.RoleDAO;
import al.sda.finalproject.bakeoff.dto.ProductDTO;
import al.sda.finalproject.bakeoff.dto.RoleDTO;
import al.sda.finalproject.bakeoff.entity.ProductEntity;
import al.sda.finalproject.bakeoff.entity.RoleEntity;
import al.sda.finalproject.bakeoff.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class RoleDAOImpl implements RoleDAO {

    private RoleRepository roleRepository;

    @Autowired
    public RoleDAOImpl(RoleRepository roleRepository){
        this.roleRepository = roleRepository;
    }

    @Override
    public List<RoleDTO> findAll() {
        return null;
    }

    @Override
    public RoleDTO findById(Long id) {
        return null;
    }

    @Override
    public void save(RoleDTO roleDTO) {

    }

    @Override
    public void deleteById(Long id) {

    }

    public static RoleEntity mapToEntity(RoleDTO roleDTO){
        RoleEntity roleEntity = new RoleEntity();
        roleEntity.setRoleName(roleDTO.getRoleName());
        roleEntity.setId(roleDTO.getId());
        roleEntity.setAuthorities(AuthorityDAOImpl.mapToEntity(roleDTO.getAuthorities()));
        return roleEntity;
    }

    public static RoleDTO mapToDTO(RoleEntity roleEntity){
        RoleDTO roleDTO = new RoleDTO();
        roleDTO.setRoleName(roleEntity.getRoleName());
        roleDTO.setAuthorities(AuthorityDAOImpl.mapToDTO(roleEntity.getAuthorities()));
        roleDTO.setId(roleEntity.getId());
        return roleDTO;
    }
}
