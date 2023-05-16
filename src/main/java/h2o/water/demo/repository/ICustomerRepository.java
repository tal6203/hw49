package h2o.water.demo.repository;

import h2o.water.demo.model.Customer;

import java.util.List;

public interface ICustomerRepository {

    int createCustomer(Customer customer);

    void updateCustomer(Customer customer, Integer id);

    void deleteCustomer(Integer id);

    List<Customer> getAllCustomers();

    Customer getCustomerById(Integer id);

}
