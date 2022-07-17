package al.sda.finalproject.bakeoff.service;

import al.sda.finalproject.bakeoff.dto.AccountDTO;

public interface AccountService extends GenericService<AccountDTO>{

    AccountDTO register(AccountDTO account);
}
