package com.neoris.bankclient.infrastructure.input.mapper;

import com.neoris.bankclient.application.command.CreateCustomerCommand;
import com.neoris.bankclient.application.command.UpdateCustomerCommand;
import com.neoris.bankclient.domain.model.Customer;
import com.neoris.bankclient.infrastructure.input.dto.CustomerRequest;
import com.neoris.bankclient.infrastructure.input.dto.CustomerResponse;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

    CustomerResponse toResponse(Customer customer);

    List<CustomerResponse> toResponseList(List<Customer> customers);

    CreateCustomerCommand toCreateCommand(CustomerRequest request);

    UpdateCustomerCommand toUpdateCommand(CustomerRequest request);
}
