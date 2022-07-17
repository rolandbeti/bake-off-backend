package al.sda.finalproject.bakeoff.service.impl;

import al.sda.finalproject.bakeoff.dao.AccountDAO;
import al.sda.finalproject.bakeoff.dao.ProductDAO;
import al.sda.finalproject.bakeoff.dto.AccountDTO;
import al.sda.finalproject.bakeoff.repository.AccountRepository;
import al.sda.finalproject.bakeoff.service.AccountService;
import al.sda.finalproject.bakeoff.service.RoleService;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

    private AccountDAO accountDAO;
    private PasswordEncoder passwordEncoder;
    private RoleService roleService;

    @Autowired
    public AccountServiceImpl(AccountDAO accountDAO, PasswordEncoder passwordEncoder, RoleService roleService, AccountRepository accountRepository){
        this.accountDAO = accountDAO;
        this.passwordEncoder = passwordEncoder;
        this.roleService = roleService;
    }

    @Override
    public List<AccountDTO> findAll() {
        return this.accountDAO.findAll();
    }

    @Override
    public AccountDTO findById(Long id) {
        return this.accountDAO.findById(id);
    }

    @Override
    public void save(AccountDTO accountDTO) {
        this.accountDAO.save(accountDTO);

    }

    @Override
    public void deleteById(Long id) {
        this.accountDAO.deleteById(id);
    }

    @Override
    public AccountDTO register(AccountDTO account) {
        AccountDTO accountToSave = new AccountDTO();
        String password = null;
        if (account.getPassword() == null){
            password = generatedPassword();
        } else{
            password = account.getPassword();
        }
        accountToSave.setRole(this.roleService.findById(2L));
        String encodedPassword = encodePassword(password);
        accountToSave.setPassword(encodedPassword);
        accountToSave.setUsername(accountToSave.getUsername());
        System.out.println("Generated Password: "+password);
        return null;
    }

    private String generatedPassword() {
        return RandomStringUtils.randomAlphanumeric(10);
    }
    private String encodePassword(String password) {
        return passwordEncoder.encode(password);
    }
}
