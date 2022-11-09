package gdsc.spring3.service;

import gdsc.spring3.dto.Customer;
import gdsc.spring3.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Transactional
    public void 회원가입(Customer customer) {
        customerRepository.save(customer);
    }

}
