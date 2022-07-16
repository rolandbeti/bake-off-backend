package al.sda.finalproject.bakeoff.service.impl;

import al.sda.finalproject.bakeoff.dao.AddressDAO;
import al.sda.finalproject.bakeoff.dto.AddressDTO;
import al.sda.finalproject.bakeoff.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {

    private AddressDAO addressDAO;

    @Autowired
    public AddressServiceImpl(AddressDAO addressDAO){
        this.addressDAO = addressDAO;
    }

    @Override
    public List<AddressDTO> findAll() {
        return  this.addressDAO.findAll();
    }

    @Override
    public AddressDTO findById(Long id) {
        return this.addressDAO.findById(id);
    }

    @Override
    public void save(AddressDTO addressDTO) {
        this.addressDAO.save(addressDTO);
    }

    @Override
    public void deleteById(Long id) {
        this.addressDAO.deleteById(id);
    }
}
