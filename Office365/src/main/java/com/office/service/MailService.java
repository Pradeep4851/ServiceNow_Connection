package com.office.service;
import java.util.Collections;
import java.util.List;

import com.azure.identity.ClientSecretCredential;
import com.azure.identity.ClientSecretCredentialBuilder;
import com.microsoft.graph.authentication.TokenCredentialAuthProvider;
import com.microsoft.graph.models.Message;
import com.microsoft.graph.requests.GraphServiceClient;

import okhttp3.Request;

public class MailService {

    private final GraphServiceClient<Request> graphClient;

    public MailService(String clientId, String clientSecret, String tenantId) {
    	System.out.println("MailService() called");
        ClientSecretCredential credential = new ClientSecretCredentialBuilder()
                .clientId(clientId)
                .clientSecret(clientSecret)
                .tenantId(tenantId)
                .build();

        TokenCredentialAuthProvider authProvider = new TokenCredentialAuthProvider(
                Collections.singletonList("https://graph.microsoft.com/.default"), credential);

        graphClient = GraphServiceClient.builder()
                .authenticationProvider(authProvider)
                .buildClient();
    }

    public List<Message> getInboxMessages() {
    	System.out.println("getInboxMessages() called");
    	
    	String userId = "Pradeep.m@nartantechnologies.com";
    	
        return graphClient.users(userId)
        		.mailFolders("inbox").messages()
                .buildRequest()
                .get()
                .getCurrentPage();
    }
}

