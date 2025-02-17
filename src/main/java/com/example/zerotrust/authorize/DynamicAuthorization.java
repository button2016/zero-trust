package com.example.zerotrust.authorize;

import java.util.*;

public class DynamicAuthorization {

    private static final Map<String, Set<String>> userPermissions = new HashMap<>();

    static {
        userPermissions.put("user1", new HashSet<>(Arrays.asList("read", "write")));
        userPermissions.put("user2", new HashSet<>(Collections.singletonList("read")));
    }

    public static boolean checkPermission(String userId, String action) {
        Set<String> permissions = userPermissions.get(userId);
        return permissions != null && permissions.contains(action);
    }

}
