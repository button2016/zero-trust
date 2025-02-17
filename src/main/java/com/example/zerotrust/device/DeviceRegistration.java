package com.example.zerotrust.device;

import java.util.HashMap;
import java.util.Map;

public class DeviceRegistration {

    private static final Map<String, DeviceEntity> devices = new HashMap<>();

    // 注册设备
    public static void registerDevice(String deviceId, String deviceType, String osVersion, String ipAddress,String mac) {
        DeviceEntity device = new DeviceEntity(deviceId, deviceType, osVersion, ipAddress,mac);
        devices.put(deviceId, device);
        System.out.println("Device registered: " + device);
    }

}
