package com.example.zerotrust.audit;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AuditLog {

    private static final List<String> logs = new ArrayList<>();

    public static void logEvent(String userId, String action) {
        String logEntry = String.format("[%s] User %s performed action: %s", new Date(), userId, action);
        logs.add(logEntry);
        System.out.println(logEntry);
    }

    public static void printLogs() {
        logs.forEach(System.out::println);
    }

}
