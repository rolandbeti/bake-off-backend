package al.sda.finalproject.bakeoff.dao.Impl;

import al.sda.finalproject.bakeoff.dao.AuthorityDAO;
import al.sda.finalproject.bakeoff.dto.AddressDTO;
import al.sda.finalproject.bakeoff.dto.AuthorityDTO;
import al.sda.finalproject.bakeoff.entity.AddressEntity;
import al.sda.finalproject.bakeoff.entity.AuthorityEntity;
import al.sda.finalproject.bakeoff.repository.AddressRepository;
import al.sda.finalproject.bakeoff.repository.AuthorityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class AuthorityDAOImpl implements AuthorityDAO {

    private AuthorityRepository authorityRepository;


    @Autowired
    public AuthorityDAOImpl(AuthorityRepository authorityRepository){
        this.authorityRepository = authorityRepository;
    }

    @Override
    public List<AuthorityDTO> findAll() {
        return this.authorityRepository.findAll()
                .stream()
                .map(AuthorityDAOImpl::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public AuthorityDTO findById(Long id) {
        Optional<AuthorityEntity> authorityEntity = this.authorityRepository.findById(id);
        return authorityEntity.map(AuthorityDAOImpl::mapToDTO).orElse(null);
    }

    @Override
    public void save(AuthorityDTO authorityDTO) {
        this.authorityRepository.save(AuthorityDAOImpl.mapToEntity(authorityDTO));
    }

    @Override
    public void deleteById(Long id) {
        this.authorityRepository.deleteById(id);
    }

    public static AuthorityEntity mapToEntity(AuthorityDTO authorityDTO){
        AuthorityEntity authorityEntity = new AuthorityEntity();
        authorityEntity.setId(authorityDTO.getId());
        authorityEntity.setAuthorityName(authorityDTO.getAuthorityName());
        return authorityEntity;
    }
    public static AuthorityDTO mapToDTO(AuthorityEntity authorityEntity){
        AuthorityDTO authorityDTO = new AuthorityDTO();
        authorityDTO.setId(authorityEntity.getId());
        authorityDTO.setAuthorityName(authorityEntity.getAuthorityName());
        return authorityDTO;
    }
}
