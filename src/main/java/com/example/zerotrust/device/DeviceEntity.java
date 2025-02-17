package com.example.zerotrust.device;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DeviceEntity {

    private String deviceId;
    private String deviceType;
    private String osVersion;
    private String ipAddress;
    private String mac;

}
