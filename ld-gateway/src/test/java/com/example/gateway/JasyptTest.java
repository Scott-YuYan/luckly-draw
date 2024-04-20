package com.example.gateway;

import org.jasypt.encryption.StringEncryptor;
import org.jasypt.encryption.pbe.PooledPBEStringEncryptor;
import org.jasypt.encryption.pbe.config.SimpleStringPBEConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author HLH
 * @description: 加密解密测试
 * @email 17703595860@163.com
 * @date : Created in 2021/8/19 19:57
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = GatewayApplication.class)
public class JasyptTest {

    @Qualifier(value = "jasyptStringEncryptor")
    @Autowired
    StringEncryptor stringEncryptor;

    /**
     * 数据库密码加密
     */
    @Test
    public void encryptHost() {
        // 加密
        System.out.println(stringEncryptor.encrypt("127.0.0.1"));    // XjYnpGd3JGICnxumpFcfRP8J83m265yC/r1FiwLr9Yo1PNbPXQ2xykLHPpy02CZ1
        // 解密
//        System.out.println(stringEncryptor.decrypt("bpGqN/RfGt1QgTBWpO0Kkhv1F1OGWrf21/QoyBGDYX7qOuTrydgik39DSflI5+FK5x1E04O8GsFeF0oKBQ4zEQ=="));    // root
    }

    @Test
    public void encryptDb() {
        // 加密
        System.out.println(stringEncryptor.encrypt("ld"));    // XjYnpGd3JGICnxumpFcfRP8J83m265yC/r1FiwLr9Yo1PNbPXQ2xykLHPpy02CZ1
        // 解密
//        System.out.println(stringEncryptor.decrypt("bpGqN/RfGt1QgTBWpO0Kkhv1F1OGWrf21/QoyBGDYX7qOuTrydgik39DSflI5+FK5x1E04O8GsFeF0oKBQ4zEQ=="));    // root
    }

    /**
     * 加密解密测试
     */
    @Test
    public void encryptUserName() {
        // 加密
        System.out.println(stringEncryptor.encrypt("root"));    // JSrINYe4IBotHndGjX1hnmY3mtPNUJlXjP12cx1+pHqUz2FNXGPu3Frnajh3QCXg
        // 解密
//        System.out.println(stringEncryptor.decrypt("iNhgtOWEIFIgCzLYd5O8Ibad/iKtHq9Zdqngscd2LmE7B1R9av3hLMMhq9T28mrU"));    // root
    }
    /**
     * 加密解密测试
     */
    @Test
    public void encryptPassWord() {
        // 加密
//        System.out.println(stringEncryptor.encrypt("password"));    // JSrINYe4IBotHndGjX1hnmY3mtPNUJlXjP12cx1+pHqUz2FNXGPu3Frnajh3QCXg
        // 解密
        // ENC@bwGi+6WiBGLUbhZhWQhyffBGdm+6cn5ufDwjpmB+P+qa9gtveYuuxVCJRhEA6BDe
        System.out.println(stringEncryptor.decrypt("bwGi+6WiBGLUbhZhWQhyffBGdm+6cn5ufDwjpmB+P+qa9gtveYuuxVCJRhEA6BDe"));    // root
    }

    /**
     * 手动测试
     */
    @Test
    public void test() {
        PooledPBEStringEncryptor encryptor = new PooledPBEStringEncryptor();
        SimpleStringPBEConfig config = new SimpleStringPBEConfig();
        config.setPassword("jaspyt_password");
        config.setAlgorithm("PBEWITHHMACSHA512ANDAES_256");
        config.setKeyObtentionIterations("1000");
        config.setPoolSize("1");
        config.setProviderName("SunJCE");
        config.setSaltGeneratorClassName("org.jasypt.salt.RandomSaltGenerator");
        config.setIvGeneratorClassName("org.jasypt.iv.RandomIvGenerator");
        config.setStringOutputType("base64");
        encryptor.setConfig(config);
        System.out.println(encryptor.encrypt("jdbc:mysql://127.0.0.1/ld"));    // JSrINYe4IBotHndGjX1hnmY3mtPNUJlXjP12cx1+pHqUz2FNXGPu3Frnajh3QCXg
    }


}