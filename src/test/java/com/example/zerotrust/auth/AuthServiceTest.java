package com.example.zerotrust.auth;

import org.junit.jupiter.api.Test;

import static com.example.zerotrust.auth.AuthService.authenticate;

public class AuthServiceTest {

    @Test
    public void authTest(){
        String clientId = "client1";
        String apiKey = "apiKey1";

        if (authenticate(clientId, apiKey)) {
            System.out.println("API access granted!");
        } else {
            System.out.println("API access denied!");
        }

    }

}
