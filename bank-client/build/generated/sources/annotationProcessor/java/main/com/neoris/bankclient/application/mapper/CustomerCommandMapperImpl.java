package com.neoris.bankclient.application.mapper;

import com.neoris.bankclient.application.command.CreateCustomerCommand;
import com.neoris.bankclient.application.command.UpdateCustomerCommand;
import com.neoris.bankclient.domain.model.Customer;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-09-16T11:21:26-0500",
    comments = "version: 1.6.3, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.14.3.jar, environment: Java 17.0.14 (Microsoft)"
)
@Component
public class CustomerCommandMapperImpl implements CustomerCommandMapper {

    @Override
    public Customer toCustomer(CreateCustomerCommand command) {
        if ( command == null ) {
            return null;
        }

        Customer customer = new Customer();

        customer.setName( command.name() );
        customer.setGender( command.gender() );
        customer.setAge( command.age() );
        customer.setIdentification( command.identification() );
        customer.setAddress( command.address() );
        customer.setPhone( command.phone() );
        customer.setPassword( command.password() );
        customer.setStatus( command.status() );

        return customer;
    }

    @Override
    public Customer toCustomer(UpdateCustomerCommand command) {
        if ( command == null ) {
            return null;
        }

        Customer customer = new Customer();

        customer.setName( command.name() );
        customer.setGender( command.gender() );
        customer.setAge( command.age() );
        customer.setIdentification( command.identification() );
        customer.setAddress( command.address() );
        customer.setPhone( command.phone() );
        customer.setCustomerId( command.customerId() );
        customer.setPassword( command.password() );
        customer.setStatus( command.status() );

        return customer;
    }
}
