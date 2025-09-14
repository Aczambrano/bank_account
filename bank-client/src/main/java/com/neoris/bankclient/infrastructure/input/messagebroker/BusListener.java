package com.neoris.bankclient.infrastructure.input.messagebroker;

import com.neoris.bankclient.application.port.input.GetCustomerByIdUseCase;
import com.neoris.bankclient.application.port.output.IRabbitListener;
import com.neoris.bankclient.domain.model.Customer;
import lombok.AllArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BusListener implements IRabbitListener {
    private final GetCustomerByIdUseCase getCustomerByIdUseCase;

    @Override
    @RabbitListener(queues = "#{rabbitProperties.getCustomerQueue()}")
    public Object receiveMessage(Integer request) {

        Integer opt = getCustomerByIdUseCase.execute(request)
                .map(Customer::getCustomerId)
                .orElse(null);
        System.out.println(opt);
        return opt;
    }

}

