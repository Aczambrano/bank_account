package com.neoris.bankclient.application.port.output;

public interface IRabbitListener {
    Object receiveMessage(Integer request);
}

