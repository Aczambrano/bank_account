package com.neoris.bankclient.infrastructure.output.repository;

import com.neoris.bankclient.infrastructure.output.entity.CustomerEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.test.context.ActiveProfiles;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ActiveProfiles("test")
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.ANY)
class CustomerRepositoryIntegrationTest {

    @Autowired
    private IOutPutCustomerRepository customerRepository;

    @Test
    void whenSaveCustomer_thenFindByIdShouldReturnCustomer() {
        CustomerEntity customer = new CustomerEntity();
        customer.setName("Anderson");
        customer.setGender("Male");
        customer.setAge(30);
        customer.setIdentification("AB123456");
        customer.setAddress("Av. Siempre Viva");
        customer.setPhone("+593987654321");
        customer.setPassword("password123");
        customer.setStatus(true);

        CustomerEntity saved = customerRepository.save(customer);
        Optional<CustomerEntity> found = customerRepository.findById(saved.getCustomerId());

        assertTrue(found.isPresent());
        assertEquals("Anderson", found.get().getName());
        assertEquals("AB123456", found.get().getIdentification());
    }
}