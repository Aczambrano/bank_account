package com.neoris.bankaccount.application.port.output;

public interface IRabbitMessage {
    Object sendMessage(Integer request);
}
