package gdsc.spring3.service;

import gdsc.spring3.dto.BankTeller;
import gdsc.spring3.dto.Customer;
import gdsc.spring3.repository.BanktellerRepository;
import gdsc.spring3.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private BanktellerRepository banktellerRepository;

    @Transactional
    public void 회원가입(Customer customer) {
        customerRepository.save(customer);
    }

    @Transactional
    public String 상품가입(String banktellerName) {

        BankTeller bankTeller = banktellerRepository.findByBanktellerName(banktellerName)
                .orElseThrow(() -> {
            return new IllegalArgumentException("존재하지 않는 은행원 입니다.");
        });

        return banktellerName;
    };

    @Transactional
    public Customer 회원찾기(int customerId) {
        Customer customer1 = customerRepository.findById(customerId).orElseThrow(()-> {
            return new IllegalArgumentException("존재하지 않는 회원입니다.");
        });

        return customer1;
    }
}


