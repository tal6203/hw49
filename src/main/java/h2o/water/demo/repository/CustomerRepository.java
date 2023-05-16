package h2o.water.demo.repository;

import h2o.water.demo.model.Customer;
import h2o.water.demo.model.CustomerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.util.Comparator;
import java.util.List;

@Repository
public class CustomerRepository implements ICustomerRepository {

    private static final String CUSTOMER_TABLE_NAME = "customer";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int createCustomer(Customer customer) {
        String query = String.format("INSERT INTO %s (first_name, last_name, email, status, student_payment_method) VALUES (?, ?, ?, ?, ?)", CUSTOMER_TABLE_NAME);
        return jdbcTemplate.update(query, customer.getFirstName(), customer.getLastName(), customer.getEmail(), customer.getStatus().name(), customer.getStudentPaymentMethod().name());
    }

    @Override
    public void updateCustomer(Customer customer, Integer id) {
        String query = String.format("UPDATE %s SET first_name=?, last_name=?, email=? , status=? , student_payment_method =? WHERE id= ?", CUSTOMER_TABLE_NAME);
        jdbcTemplate.update(query, customer.getFirstName(), customer.getLastName(), customer.getEmail(), customer.getStatus().name(), customer.getStudentPaymentMethod().name(), id);
    }

    @Override
    public void deleteCustomer(Integer id) {
        String query = String.format("DELETE FROM %s WHERE id= ?", CUSTOMER_TABLE_NAME);
        jdbcTemplate.update(query, id);
    }

    @Override
    public List<Customer> getAllCustomers() {
        String query = String.format("Select * from %s", CUSTOMER_TABLE_NAME);
        return jdbcTemplate.query(query, new CustomerMapper());

        // inline mapper
        /*
        return jdbcTemplate.query(
                query,
                (rs, rowNum) ->
                        new Customer(
                                rs.getInt("id"),
                                rs.getString("first_name"),
                                rs.getString("last_name"),
                                rs.getString("email")));
         */

    }

    @Override
    public Customer getCustomerById(Integer id) {
        String query = String.format("Select * from %s where id=?", CUSTOMER_TABLE_NAME);
        try
        {
            return jdbcTemplate.queryForObject(query, new CustomerMapper(), id);
        }
        catch (EmptyResultDataAccessException e) {
            return null;
        }

        // inline mapper
        /*
        return jdbcTemplate.queryForObject(
                query,
                (rs, rowNum) ->
                        new Customer(
                                rs.getInt("id"),
                                rs.getString("first_name"),
                                rs.getString("last_name"),
                                rs.getString("email")),
                                id);
         */
    }

}
