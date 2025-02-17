package com.example.zerotrust.audit;

import org.junit.jupiter.api.Test;

import static com.example.zerotrust.audit.AuditLog.logEvent;
import static com.example.zerotrust.audit.AuditLog.printLogs;

public class AuditLogTest {

    @Test
    public void auditLog(){
        logEvent("user1", "login");
        logEvent("user2", "edit_document");
        printLogs();
    }

}
