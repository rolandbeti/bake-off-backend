package al.sda.finalproject.bakeoff.service.impl;



import al.sda.finalproject.bakeoff.dao.AuthorityDAO;
import al.sda.finalproject.bakeoff.dto.AuthorityDTO;
import al.sda.finalproject.bakeoff.service.AuthorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorityServiceImpl implements AuthorityService {

    private AuthorityDAO authorityDAO;

    @Autowired
    public AuthorityServiceImpl(AuthorityDAO authorityDAO){
        this.authorityDAO =  authorityDAO;
    }

    @Override
    public List<AuthorityDTO> findAll() {
        return  this.authorityDAO.findAll();
    }

    @Override
    public AuthorityDTO findById(Long id) {
        return this.authorityDAO.findById(id);
    }

    @Override
    public void save(AuthorityDTO authorityDTO) {
        this.authorityDAO.save(authorityDTO);
    }

    @Override
    public void deleteById(Long id) {
        this.authorityDAO.deleteById(id);
    }
}
