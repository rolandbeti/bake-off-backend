package al.sda.finalproject.bakeoff.dao.Impl;

import al.sda.finalproject.bakeoff.dao.AddressDAO;
import al.sda.finalproject.bakeoff.dto.AddressDTO;
import al.sda.finalproject.bakeoff.entity.AddressEntity;
import al.sda.finalproject.bakeoff.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class AddressDAOImpl implements AddressDAO {

    private AddressRepository addressRepository;


    @Autowired
    public AddressDAOImpl(AddressRepository addressRepository){
        this.addressRepository = addressRepository;
    }

    public static AddressEntity mapToDTO(String email) {
    }

    @Override
    public List<AddressDTO> findAll() {
        return this.addressRepository.findAll().stream().map(AddressDAOImpl::mapToDTO).collect(Collectors.toList());
    }

    @Override
    public AddressDTO findById(Long id) {
        Optional<AddressEntity> addressEntity = this.addressRepository.findById(id);
        return addressEntity.map(AddressDAOImpl::mapToDTO).orElse(null);
    }

    @Override
    public void save(AddressDTO addressDTO) {
        this.addressRepository.save(AddressDAOImpl.mapToEntity(addressDTO));
    }

    @Override
    public void deleteById(Long id) {
        this.addressRepository.deleteById(id);
    }

    public static AddressEntity mapToEntity(AddressDTO addressDTO){
        AddressEntity addressEntity = new AddressEntity();
        addressEntity.setId(addressDTO.getId());
        addressEntity.setCountry(addressDTO.getCountry());
        addressEntity.setCity(addressDTO.getCity());
        addressEntity.setStreet(addressDTO.getStreet());
        addressEntity.setPostalCode(addressDTO.getPostalCode());
        return addressEntity;
    }
    public static AddressDTO mapToDTO(AddressEntity addressEntity){
        AddressDTO addressDTO = new AddressDTO();
        addressDTO.setId(addressEntity.getId());
        addressDTO.setCountry(addressEntity.getCountry());
        addressDTO.setCity(addressEntity.getCity());
        addressDTO.setStreet(addressEntity.getStreet());
        addressDTO.setPostalCode(addressEntity.getPostalCode());
        return addressDTO;
    }
}
