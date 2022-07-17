package al.sda.finalproject.bakeoff.service.impl;

import al.sda.finalproject.bakeoff.dao.RoleDAO;
import al.sda.finalproject.bakeoff.dto.RoleDTO;
import al.sda.finalproject.bakeoff.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RoleServiceImpl implements RoleService {

    private RoleDAO roleDAO;

    @Autowired
    public RoleServiceImpl(RoleDAO roleDAO){
        this.roleDAO = roleDAO;
    }

    @Override
    public List<RoleDTO> findAll() {
        return this.roleDAO.findAll();
    }

    @Override
    public RoleDTO findById(Long id) {
        return this.roleDAO.findById(id);
    }

    @Override
    public void save(RoleDTO roleDTO) {
        this.roleDAO.save(roleDTO);
    }

    @Override
    public void deleteById(Long id) {
        this.roleDAO.deleteById(id);
    }
}
