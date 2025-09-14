package com.neoris.bankclient.infrastructure.output.repository;

import com.neoris.bankclient.infrastructure.output.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface IOutPutCustomerRepository extends JpaRepository<CustomerEntity, Integer> {
    Optional<CustomerEntity> findById(Integer id);
    Optional<CustomerEntity> findByIdentification(String identification);
    List<CustomerEntity> findAll();

}
