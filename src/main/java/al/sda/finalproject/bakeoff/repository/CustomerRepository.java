package al.sda.finalproject.bakeoff.repository;


import al.sda.finalproject.bakeoff.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<CustomerEntity, Long> {
}
