package al.sda.finalproject.bakeoff.repository;

import al.sda.finalproject.bakeoff.entity.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<AccountEntity, Long> {
    AccountEntity findAccountEntityByUsername(String username);
}
