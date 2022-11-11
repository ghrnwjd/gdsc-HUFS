package gdsc.spring3.service;

import gdsc.spring3.dto.BankTeller;
import gdsc.spring3.dto.Customer;
import gdsc.spring3.repository.BanktellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BanktellerService {

    @Autowired
    private BanktellerRepository banktellerRepository;

    @Transactional
    public void 회원가입(BankTeller bankTeller) {
        banktellerRepository.save(bankTeller);
    }
}
