package com.neoris.bankclient.infrastructure.output.mapper;

import com.neoris.bankclient.domain.model.Customer;
import com.neoris.bankclient.infrastructure.output.entity.CustomerEntity;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-09-14T13:16:53-0500",
    comments = "version: 1.6.3, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.14.3.jar, environment: Java 17.0.14 (Microsoft)"
)
@Component
public class CustomerEntityMapperImpl implements CustomerEntityMapper {

    @Override
    public Customer toDomain(CustomerEntity entity) {
        if ( entity == null ) {
            return null;
        }

        Customer customer = new Customer();

        customer.setName( entity.getName() );
        customer.setGender( entity.getGender() );
        customer.setAge( entity.getAge() );
        customer.setIdentification( entity.getIdentification() );
        customer.setAddress( entity.getAddress() );
        customer.setPhone( entity.getPhone() );
        customer.setCustomerId( entity.getCustomerId() );
        customer.setPassword( entity.getPassword() );
        customer.setStatus( entity.getStatus() );

        return customer;
    }

    @Override
    public CustomerEntity toEntity(Customer customer) {
        if ( customer == null ) {
            return null;
        }

        CustomerEntity customerEntity = new CustomerEntity();

        customerEntity.setName( customer.getName() );
        customerEntity.setGender( customer.getGender() );
        customerEntity.setAge( customer.getAge() );
        customerEntity.setIdentification( customer.getIdentification() );
        customerEntity.setAddress( customer.getAddress() );
        customerEntity.setPhone( customer.getPhone() );
        customerEntity.setCustomerId( customer.getCustomerId() );
        customerEntity.setPassword( customer.getPassword() );
        customerEntity.setStatus( customer.getStatus() );

        return customerEntity;
    }
}
