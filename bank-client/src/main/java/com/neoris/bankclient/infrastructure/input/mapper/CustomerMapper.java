package com.neoris.bankclient.infrastructure.input.mapper;

import com.neoris.bankclient.domain.model.Customer;
import com.neoris.bankclient.infrastructure.input.dto.CustomerRequest;
import com.neoris.bankclient.infrastructure.input.dto.CustomerResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

    Customer toEntity(CustomerRequest customerRequest);

    CustomerResponse toResponse(Customer customer);
}
