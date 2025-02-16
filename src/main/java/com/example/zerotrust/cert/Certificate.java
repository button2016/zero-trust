package com.example.zerotrust.cert;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.Date;

import org.bouncycastle.asn1.x500.X500Name;
import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import org.bouncycastle.cert.X509v3CertificateBuilder;
import org.bouncycastle.cert.jcajce.JcaX509CertificateConverter;
import org.bouncycastle.cert.jcajce.JcaX509v3CertificateBuilder;
import org.bouncycastle.operator.ContentSigner;
import org.bouncycastle.operator.OperatorCreationException;
import org.bouncycastle.operator.jcajce.JcaContentSignerBuilder;

public class Certificate {

    // 生成自签名证书
    public static X509Certificate generateSelfSignedCertificate(String commonName, Date validFrom, Date validTo)
            throws NoSuchAlgorithmException, OperatorCreationException, CertificateException, IOException {
        // 生成密钥对
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        keyPairGenerator.initialize(2048);
        KeyPair keyPair = keyPairGenerator.generateKeyPair();
        PrivateKey privateKey = keyPair.getPrivate();
        PublicKey publicKey = keyPair.getPublic();

        // 创建证书主题
        X500Name subject = new X500Name("CN=" + commonName);

        // 创建证书构建器
        X509v3CertificateBuilder certificateBuilder = new JcaX509v3CertificateBuilder(
                subject,
                BigInteger.valueOf(System.currentTimeMillis()),
                validFrom,
                validTo,
                subject,
                publicKey
        );

        // 使用私钥签名证书
        ContentSigner contentSigner = new JcaContentSignerBuilder("SHA256WithRSAEncryption")
                .build(privateKey);
        X509Certificate certificate = new JcaX509CertificateConverter()
                .getCertificate(certificateBuilder.build(contentSigner));

        return certificate;
    }

    // 解析证书
    public static X509Certificate parseCertificate(byte[] certData) throws CertificateException {
        CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
        return (X509Certificate) certificateFactory.generateCertificate(new ByteArrayInputStream(certData));
    }
}