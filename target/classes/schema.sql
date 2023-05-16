DROP TABLE IF EXISTS customer_order;
DROP TABLE IF EXISTS customer;

CREATE TABLE customer (
    id int auto_increment,
    first_name varchar(255) NOT NULL default '',
    last_name varchar(255) NOT NULL default '',
    email varchar(255) NOT NULL default '',
    status varchar(255) NOT NULL default '',
    student_payment_method varchar(255) NOT NULL default '',
    PRIMARY KEY (id)
);
CREATE TABLE customer_order (
    id int auto_increment,
    customer_id int NOT NULL,
    item_name varchar(255) NOT NULL default '',
    price DECIMAL(100,2) NOT NULL default 0,
    PRIMARY KEY (id),
    FOREIGN KEY (customer_id) REFERENCES customer(id)
);
