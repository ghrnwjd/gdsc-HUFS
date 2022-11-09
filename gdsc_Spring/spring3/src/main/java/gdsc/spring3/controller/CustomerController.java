package gdsc.spring3.controller;

import gdsc.spring3.dto.Customer;
import gdsc.spring3.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class CustomerController {

    // 만약 회원가입 사이트가 있다면
    /*
    @Autowired
    private CustomerService customerService;

    @PostMapping("localhost:8080/join")
    public void join(@RequestBody Customer customer) {
        customerService.회원가입(customer);
    }

     */


}
