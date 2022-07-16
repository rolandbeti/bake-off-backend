package al.sda.finalproject.bakeoff.service.impl;

import al.sda.finalproject.bakeoff.dao.AccountDAO;
import al.sda.finalproject.bakeoff.dao.ProductDAO;
import al.sda.finalproject.bakeoff.dto.AccountDTO;
import al.sda.finalproject.bakeoff.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

    private AccountDAO accountDAO;

    @Autowired
    public AccountServiceImpl(AccountDAO accountDAO){
        this.accountDAO = accountDAO;
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
}
