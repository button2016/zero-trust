package com.example.zerotrust.cert;

import org.junit.jupiter.api.Test;

import java.security.cert.X509Certificate;
import java.util.Date;

import static com.example.zerotrust.cert.Certificate.generateSelfSignedCertificate;
import static com.example.zerotrust.cert.Certificate.parseCertificate;

public class CertificateTest {

    @Test
    public void generateCert(){
        try {
            // 生成自签名证书
            Date validFrom = new Date();
            Date validTo = new Date(System.currentTimeMillis() + 365 * 24 * 60 * 60 * 1000L); // 1年有效期
            X509Certificate certificate = generateSelfSignedCertificate("example.com", validFrom, validTo);

            // 打印证书信息
            System.out.println("Issuer: " + certificate.getIssuerX500Principal().getName());
            System.out.println("Subject: " + certificate.getSubjectX500Principal().getName());
            System.out.println("Valid From: " + certificate.getNotBefore());
            System.out.println("Valid To: " + certificate.getNotAfter());

            // 解析证书
            byte[] certData = certificate.getEncoded();
            X509Certificate parsedCertificate = parseCertificate(certData);
            System.out.println("Parsed Certificate: " + parsedCertificate);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
