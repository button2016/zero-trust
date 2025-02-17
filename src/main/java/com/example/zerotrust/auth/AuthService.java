package com.example.zerotrust.auth;

import java.util.HashMap;
import java.util.Map;

public class AuthService {

    private static final Map<String, String> apiKeys = new HashMap<>();

    static {
        apiKeys.put("client1", "apiKey1");
        apiKeys.put("client2", "apiKey2");
    }

    public static boolean authenticate(String clientId, String apiKey) {
        return apiKeys.get(clientId) != null && apiKeys.get(clientId).equals(apiKey);
    }


}
