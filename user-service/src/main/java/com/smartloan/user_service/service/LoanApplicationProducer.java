package com.smartloan.user_service.service;

import com.smartloan.user_service.model.LoanApplication;
import com.smartloan.user_service.repository.LoanApplicationRepository;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class LoanApplicationProducer {

    private final RabbitTemplate rabbitTemplate;
    private final LoanApplicationRepository repository;

    @Value("${rabbitmq.queue.name}")
    private String queueName;

    public LoanApplicationProducer(RabbitTemplate rabbitTemplate,
                                   LoanApplicationRepository repository) {
        this.rabbitTemplate = rabbitTemplate;
        this.repository = repository;
    }

    public void sendLoanApplication(LoanApplication application) {
        // Step 1: Set default status
        application.setStatus("PENDING");

        // Step 2: Save to the database
        LoanApplication saved = repository.save(application);

        // Step 3: Send to RabbitMQ for processing
        rabbitTemplate.convertAndSend(queueName, saved);
    }
}
