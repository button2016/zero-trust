package com.example.zerotrust.cipher;

import org.junit.jupiter.api.Test;

import javax.crypto.SecretKey;

import static com.example.zerotrust.cipher.DataEncryption.*;

public class DataEncryptionTest {

    @Test
    public void testData() throws Exception {
        SecretKey key = generateKey();
        String originalData = "Sensitive data";

        String encryptedData = encrypt(originalData, key);
        System.out.println("Encrypted: " + encryptedData);

        String decryptedData = decrypt(encryptedData, key);
        System.out.println("Decrypted: " + decryptedData);
    }

}
