package com.smartloan.user_service.service;

import com.smartloan.user_service.model.LoanApplication;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class LoanApplicationConsumer {

    @RabbitListener(queues = "${rabbitmq.queue.name}")
    public void receiveLoanApplication(LoanApplication loanApplication) {
        System.out.println("Received loan application: " + loanApplication);
    }
}
