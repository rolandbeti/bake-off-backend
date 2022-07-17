package al.sda.finalproject.bakeoff.repository;

import al.sda.finalproject.bakeoff.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    UserEntity findUserEntityByUsername(String username);
    UserEntity findUserEntityByEmail(String email);
}
