package al.sda.finalproject.bakeoff.service.impl;

import al.sda.finalproject.bakeoff.dao.CustomerDAO;
import al.sda.finalproject.bakeoff.dto.CustomerDTO;
import al.sda.finalproject.bakeoff.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    private CustomerDAO customerDAO;

    @Autowired
    public CustomerServiceImpl(CustomerDAO  customerDAO){
        this.customerDAO = customerDAO;
    }

    @Override
    public List<CustomerDTO> findAll() {
        return this.customerDAO.findAll();
    }

    @Override
    public CustomerDTO findById(Long id) {
        return this.customerDAO.findById(id);
    }

    @Override
    public void save(CustomerDTO customerDTO) {
     this.customerDAO.save(customerDTO);
    }

    @Override
    public void deleteById(Long id) {
        this.customerDAO.deleteById(id);
    }
}
