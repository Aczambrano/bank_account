package com.neoris.bankclient.infrastructure.output.adapter;

import com.neoris.bankclient.application.port.output.ICustomerRepository;
import com.neoris.bankclient.domain.model.Customer;
import com.neoris.bankclient.infrastructure.output.entity.CustomerEntity;
import com.neoris.bankclient.infrastructure.output.mapper.CustomerEntityMapper;
import com.neoris.bankclient.infrastructure.output.repository.IOutPutCustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
@AllArgsConstructor
public class ImplCustomerRepository implements ICustomerRepository {

    private final IOutPutCustomerRepository customerRepository;
    private final CustomerEntityMapper customerEntityMapper;

    @Override
    public Customer save(Customer customer) {
        CustomerEntity customerEntity = customerEntityMapper.toEntity(customer);

        CustomerEntity savedEntity = customerRepository.save(customerEntity);
        return customerEntityMapper.toDomain(savedEntity);
    }

    @Override
    public Customer update(Customer customer) {
        CustomerEntity customerEntity = customerEntityMapper.toEntity(customer);
        customerRepository.save(customerEntity);
        return customerEntityMapper.toDomain(customerEntity);
    }

    @Override
    public List<Customer> findAll() {
        List<CustomerEntity> customerEntities = customerRepository.findAll();
        return customerEntities.stream()
                .map(customerEntityMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Customer> findById(Integer id) {
        Optional<CustomerEntity> customerEntity = customerRepository.findById(id);
        return customerEntity.map(customerEntityMapper::toDomain);
    }

    @Override
    public Optional<Customer> findByIdentification(String identification) {
        Optional<CustomerEntity> customerEntity = customerRepository.findByIdentification(identification);
        return customerEntity.map(customerEntityMapper::toDomain);
    }

}

