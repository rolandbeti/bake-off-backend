package al.sda.finalproject.bakeoff.dao.Impl;


import al.sda.finalproject.bakeoff.dao.CustomerDAO;
import al.sda.finalproject.bakeoff.dto.CustomerDTO;
import al.sda.finalproject.bakeoff.entity.CustomerEntity;
import al.sda.finalproject.bakeoff.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class CustomerDAOImpl implements CustomerDAO {

    private CustomerRepository customerRepository;

    @Autowired
    public CustomerDAOImpl(CustomerRepository customerRepository){
        this.customerRepository = customerRepository;
    }

    @Override
    public List<CustomerDTO> findAll() {
        return  this.customerRepository.findAll()
                .stream()
                .map(CustomerDAOImpl::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public CustomerDTO findById(Long id) {
        Optional<CustomerEntity>  customerEntity = this.customerRepository.findById(id);
        return customerEntity.map(CustomerDAOImpl::mapToDTO).orElse(null);
    }

    @Override
    public void save(CustomerDTO customerDTO) {
        this.customerRepository.save(CustomerDAOImpl.mapToEntity(customerDTO));
    }

    @Override
    public void deleteById(Long id) {
        this.customerRepository.deleteById(id);
    }

    public static CustomerEntity mapToEntity(CustomerDTO customerDTO){
        CustomerEntity customerEntity = new CustomerEntity();
        customerEntity.setAddress(AddressDAOImpl.mapToEntity(customerDTO.getAddress()));
        customerEntity.setEmail(customerDTO.getEmail());
        customerEntity.setId(customerDTO.getId());
        customerEntity.setFirstName(customerDTO.getFirstName());
        customerEntity.setLastName(customerDTO.getLastName());
        customerEntity.setAccount(AccountDAOImpl.mapToEntity(customerDTO.getAccount()));
        return customerEntity;
    }
    public static CustomerDTO mapToDTO(CustomerEntity customerEntity){
        CustomerDTO customerDTO = new CustomerDTO();
         customerDTO.setAddress(AddressDAOImpl.mapToDTO(customerEntity.getAddress()));
         customerDTO.setEmail((customerEntity.getEmail()));
         customerDTO.setId(customerEntity.getId());
         customerDTO.setFirstName(customerEntity.getFirstName());
         customerDTO.setLastName(customerEntity.getLastName());
         customerDTO.setAccount(AccountDAOImpl.mapToDTO(customerEntity.getAccount()));
         return customerDTO;
    }

}
