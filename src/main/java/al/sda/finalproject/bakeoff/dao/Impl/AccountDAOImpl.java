package al.sda.finalproject.bakeoff.dao.Impl;

import al.sda.finalproject.bakeoff.dao.AccountDAO;
import al.sda.finalproject.bakeoff.dto.AccountDTO;
import al.sda.finalproject.bakeoff.entity.AccountEntity;
import al.sda.finalproject.bakeoff.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class AccountDAOImpl implements AccountDAO {

    private AccountRepository accountRepository;


    @Autowired
    public AccountDAOImpl(AccountRepository accountRepository){
        this.accountRepository = accountRepository;
    }

    @Override
    public List<AccountDTO> findAll() {
         return this.accountRepository.findAll().stream().map(AccountDAOImpl::mapToDTO).collect(Collectors.toList());
    }

    @Override
    public AccountDTO findById(Long id) {
        Optional<AccountEntity> accountEntity = this.accountRepository.findById(id);
        return accountEntity.map(AccountDAOImpl::mapToDTO).orElse(null);
    }

    @Override
    public void save(AccountDTO accountDTO) {
        this.accountRepository.save(AccountDAOImpl.mapToEntity(accountDTO));
    }

    @Override
    public void deleteById(Long id) {
        this.accountRepository.deleteById(id);
    }

    public static AccountEntity mapToEntity(AccountDTO accountDTO){
        AccountEntity accountEntity = new AccountEntity();
        accountEntity.setRole(RoleDAOImpl.mapToEntity(accountDTO.getRole()));
        accountEntity.setId(accountDTO.getId());
        accountEntity.setUsername(accountDTO.getUsername());
        accountEntity.setPassword(accountDTO.getPassword());
        return accountEntity;
    }
    public static AccountDTO mapToDTO(AccountEntity accountEntity){
        AccountDTO accountDTO = new AccountDTO();
        accountDTO.setRole(RoleDAOImpl.mapToDTO(accountEntity.getRole()));
        accountDTO.setId(accountEntity.getId());
        accountDTO.setUsername(accountEntity.getUsername());
        accountDTO.setPassword(accountEntity.getPassword());
        return accountDTO;
    }

}
