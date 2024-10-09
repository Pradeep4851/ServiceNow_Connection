package com.office.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.microsoft.graph.http.GraphServiceException;
import com.microsoft.graph.models.Message;

@Service
public class EmailService {

    private final MailService mailService;

    public EmailService(
        @Value("${azure.client-id}") String clientId,
        @Value("${azure.client-secret}") String clientSecret,
        @Value("${azure.tenant-id}") String tenantId) {

        this.mailService = new MailService(clientId, clientSecret, tenantId);
    }

    public void readEmails() {
    	System.out.println("readEmails() called");
        
        try {
            List<Message> messages = mailService.getInboxMessages();
            
            messages.forEach(message -> {
                System.out.println("Subject: " + message.subject);
                System.out.println("Body: " + message.bodyPreview);
            });
            
        } catch (GraphServiceException e) {
            System.err.println("Error code: " + e.getServiceError().code);
            System.err.println("Error message: " + e.getServiceError().message);
        }
        
        
        
    }
}
