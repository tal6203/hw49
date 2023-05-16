package h2o.water.demo.model;

/*
CREATE TABLE customer (
    id int auto_increment,
    first_name varchar(255) NOT NULL default '',
    last_name varchar(255) NOT NULL default '',
    email varchar(255) NOT NULL default '',
    PRIMARY KEY (id)
); */

import lombok.Getter;
import lombok.Setter;

public class Customer {

    @Getter@Setter
    protected Integer id;

    @Getter@Setter
    protected String firstName;

    @Getter@Setter
    protected String lastName;

    @Getter@Setter
    protected String email;

    @Getter@Setter
    protected CustomerStatus status;

    @Getter@Setter
    protected StudentPaymentMethod studentPaymentMethod;


    public Customer(Integer id, String firstName, String lastName, String email,CustomerStatus status,StudentPaymentMethod studentPaymentMethod) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.status = status;
        this.studentPaymentMethod = studentPaymentMethod;

    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
