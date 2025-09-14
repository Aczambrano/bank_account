CREATE TABLE customer (
                          customer_id INT AUTO_INCREMENT PRIMARY KEY,
                          name VARCHAR(255),
                          gender VARCHAR(50),
                          age INT,
                          identification VARCHAR(50),
                          address VARCHAR(255),
                          phone VARCHAR(50),
                          password VARCHAR(255),
                          status BOOLEAN
);
