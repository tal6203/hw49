package h2o.water.demo.controller;

import h2o.water.demo.model.Customer;
import h2o.water.demo.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.relational.core.sql.In;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {

    @Autowired
    CustomerRepository customerRepository;

    @GetMapping
    public List<Customer> get() {
        return customerRepository.getAllCustomers();
    }

    @GetMapping(value ="/{id}")
    public Customer getById(@PathVariable Integer id) {
        return customerRepository.getCustomerById(id);
    }

    @PostMapping()
    public Customer post(@RequestBody Customer customer) {
        customer.setId(customerRepository.createCustomer(customer));
        return customer;
    }

    @PutMapping(value = "/{id}")
    public Customer put(@PathVariable Integer id, @RequestBody Customer customer) {
        customerRepository.updateCustomer(customer, id);
        return customer;
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable Integer id) {
        customerRepository.deleteCustomer(id);
    }

}
