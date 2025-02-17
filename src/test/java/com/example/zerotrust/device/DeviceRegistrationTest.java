package com.example.zerotrust.device;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static com.example.zerotrust.device.DeviceRegistration.registerDevice;

public class DeviceRegistrationTest {

    @Test
    public void registrationTest(){
        registerDevice("device1", "Laptop", "Windows 10", "192.168.1.100","MAC1");
        registerDevice("device2", "Smartphone", "Android 12", "192.168.1.101","MAC2");
    }

}
