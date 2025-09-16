package com.neoris.bankclient.infrastructure.input.mapper;

import com.neoris.bankclient.application.command.CreateCustomerCommand;
import com.neoris.bankclient.application.command.UpdateCustomerCommand;
import com.neoris.bankclient.domain.model.Customer;
import com.neoris.bankclient.infrastructure.input.dto.CustomerRequest;
import com.neoris.bankclient.infrastructure.input.dto.CustomerResponse;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-09-16T11:21:26-0500",
    comments = "version: 1.6.3, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.14.3.jar, environment: Java 17.0.14 (Microsoft)"
)
@Component
public class CustomerMapperImpl implements CustomerMapper {

    @Override
    public CustomerResponse toResponse(Customer customer) {
        if ( customer == null ) {
            return null;
        }

        Integer customerId = null;
        String name = null;
        String gender = null;
        Integer age = null;
        String identification = null;
        String address = null;
        String phone = null;
        Boolean status = null;
        String password = null;

        customerId = customer.getCustomerId();
        name = customer.getName();
        gender = customer.getGender();
        age = customer.getAge();
        identification = customer.getIdentification();
        address = customer.getAddress();
        phone = customer.getPhone();
        status = customer.getStatus();
        password = customer.getPassword();

        CustomerResponse customerResponse = new CustomerResponse( customerId, name, gender, age, identification, address, phone, status, password );

        return customerResponse;
    }

    @Override
    public List<CustomerResponse> toResponseList(List<Customer> customers) {
        if ( customers == null ) {
            return null;
        }

        List<CustomerResponse> list = new ArrayList<CustomerResponse>( customers.size() );
        for ( Customer customer : customers ) {
            list.add( toResponse( customer ) );
        }

        return list;
    }

    @Override
    public CreateCustomerCommand toCreateCommand(CustomerRequest request) {
        if ( request == null ) {
            return null;
        }

        String name = null;
        String gender = null;
        Integer age = null;
        String identification = null;
        String address = null;
        String phone = null;
        String password = null;
        Boolean status = null;

        name = request.name();
        gender = request.gender();
        age = request.age();
        identification = request.identification();
        address = request.address();
        phone = request.phone();
        password = request.password();
        status = request.status();

        CreateCustomerCommand createCustomerCommand = new CreateCustomerCommand( name, gender, age, identification, address, phone, password, status );

        return createCustomerCommand;
    }

    @Override
    public UpdateCustomerCommand toUpdateCommand(CustomerRequest request) {
        if ( request == null ) {
            return null;
        }

        Integer customerId = null;
        String name = null;
        String gender = null;
        Integer age = null;
        String identification = null;
        String address = null;
        String phone = null;
        String password = null;
        Boolean status = null;

        customerId = request.customerId();
        name = request.name();
        gender = request.gender();
        age = request.age();
        identification = request.identification();
        address = request.address();
        phone = request.phone();
        password = request.password();
        status = request.status();

        UpdateCustomerCommand updateCustomerCommand = new UpdateCustomerCommand( customerId, name, gender, age, identification, address, phone, password, status );

        return updateCustomerCommand;
    }
}
