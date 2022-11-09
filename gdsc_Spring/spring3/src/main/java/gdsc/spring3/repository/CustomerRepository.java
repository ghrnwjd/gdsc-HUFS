package gdsc.spring3.repository;

import gdsc.spring3.dto.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository <Customer, Integer> {

}
