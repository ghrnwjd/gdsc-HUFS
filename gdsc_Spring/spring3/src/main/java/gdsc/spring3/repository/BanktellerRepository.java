package gdsc.spring3.repository;

import gdsc.spring3.dto.BankTeller;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BanktellerRepository extends JpaRepository<BankTeller, Integer> {
    // SELECT * FROM bankteller WHERE banktellerName = ?
    Optional<BankTeller> findByBanktellerName(String banktellerName);
}
