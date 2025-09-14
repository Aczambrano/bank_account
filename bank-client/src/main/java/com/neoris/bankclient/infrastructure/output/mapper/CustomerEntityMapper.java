package com.neoris.bankclient.infrastructure.output.mapper;

import com.neoris.bankclient.domain.model.Customer;
import com.neoris.bankclient.infrastructure.output.entity.CustomerEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerEntityMapper {

    Customer toDomain(CustomerEntity entity);

    CustomerEntity toEntity(Customer customer);
}