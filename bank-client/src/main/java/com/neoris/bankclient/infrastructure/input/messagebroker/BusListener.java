package com.neoris.bankclient.infrastructure.input.messagebroker;

import com.neoris.bankclient.application.port.output.IRabbitListener;
import com.neoris.bankclient.application.query.GetCustomerByIdQuery;
import com.neoris.bankclient.application.query.handler.GetCustomerByIdHandler;
import com.neoris.bankclient.domain.model.Customer;
import lombok.AllArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BusListener implements IRabbitListener {
    private final GetCustomerByIdHandler getCustomerByIdhandler;

    @Override
    @RabbitListener(queues = "#{rabbitProperties.getCustomerQueue()}")
    public Object receiveMessage(Integer customerId) {
        return getCustomerByIdhandler.handle(new GetCustomerByIdQuery(customerId))
                .map(Customer::getCustomerId)
                .orElse(null);
    }

}

