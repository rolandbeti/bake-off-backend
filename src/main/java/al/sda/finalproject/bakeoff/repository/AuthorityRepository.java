package al.sda.finalproject.bakeoff.repository;

import al.sda.finalproject.bakeoff.entity.AuthorityEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorityRepository extends JpaRepository<AuthorityEntity, Long> {
}
