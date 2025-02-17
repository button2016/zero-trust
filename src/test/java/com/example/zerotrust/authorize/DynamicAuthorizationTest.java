package com.example.zerotrust.authorize;

import org.junit.jupiter.api.Test;

public class DynamicAuthorizationTest {

    @Test
    public void authorize(){
        String userId = "user2";
        String action = "write";

        if (DynamicAuthorization.checkPermission(userId, action)) {
            System.out.println("Permission granted!");
        } else {
            System.out.println("Permission denied!");
        }
    }
}
