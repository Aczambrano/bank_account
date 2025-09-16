package com.neoris.bankclient.application.mapper;

import com.neoris.bankclient.application.command.CreateCustomerCommand;
import com.neoris.bankclient.application.command.UpdateCustomerCommand;
import com.neoris.bankclient.domain.model.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CustomerCommandMapper {

    @Mapping(target = "customerId", ignore = true)
    Customer toCustomer(CreateCustomerCommand command);

    Customer toCustomer(UpdateCustomerCommand command);
}
