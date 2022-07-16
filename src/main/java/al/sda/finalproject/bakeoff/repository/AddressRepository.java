package al.sda.finalproject.bakeoff.repository;

import al.sda.finalproject.bakeoff.entity.AddressEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository  extends JpaRepository<AddressEntity, Long> {
}
