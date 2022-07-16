package al.sda.finalproject.bakeoff.repository;

import al.sda.finalproject.bakeoff.entity.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<AccountEntity, Long> {
}
