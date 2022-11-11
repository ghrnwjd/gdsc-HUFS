package gdsc.spring3.controller;

import gdsc.spring3.dto.Customer;
import gdsc.spring3.repository.CustomerRepository;
import gdsc.spring3.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class CustomerApiController {

    // 만약 해당되는 사이트가 있다면

    @Autowired
    private CustomerService customerService;

    @PostMapping("localhost:8080/join")
    public void join(@RequestBody Customer customer) {
        customerService.회원가입(customer);
    }

}
