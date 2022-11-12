package gdsc.spring3.controller;

import gdsc.spring3.dto.Customer;
import gdsc.spring3.repository.CustomerRepository;
import gdsc.spring3.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CustomerController {

    @Autowired
    private CustomerService customerService;
    @Autowired
    private CustomerRepository customerRepository;

    @GetMapping("localhost:8080/{banktellerName}")
    public void join_service(@RequestParam String bankTellerName) {

        // 논리적인 비약이 많지만 이미 로그인 된 회원의 정보를 받아올 수 있어야 하지만
        // 일단은 첫번쨰 회원에 대해서만 서비스 가입이 된다고 가정하겠다.

        Customer customer = customerService.회원찾기(1);
        customer.setService_bankteller(true, customerService.상품가입(bankTellerName));
        customerRepository.save(customer);

    }

    @GetMapping("localhost:8080/{customerId}/{banktellerName}")
    public void drop_service(@RequestParam int customerId, String bankTellerName) {

        // 논리적인 비약이 많지만 이미 로그인 된 회원의 정보를 받아올 수 있어야 하지만
        // 일단은 첫번쨰 회원에 대해서만 서비스 가입이 된다고 가정하겠다.

        Customer customer = customerService.회원찾기(1);
        customerService.상품탈퇴(customerId, bankTellerName);
        customerRepository.save(customer);

    }
}
