package com.example.bldbase.utils;

import org.jasypt.encryption.pbe.PooledPBEStringEncryptor;
import org.jasypt.encryption.pbe.config.SimpleStringPBEConfig;


public class JasyptUtil {

    /**
     * PBE 算法
     */
    public static final String PBE_ALGORITHMS_MD5_DES = "PBEWITHMD5ANDDES";
    public static final String PBE_ALGORITHMS_MD5_TRIPLEDES = "PBEWITHMD5ANDTRIPLEDES";
    public static final String PBE_ALGORITHMS_SHA1_DESEDE = "PBEWITHSHA1ANDDESEDE";
    public static final String PBE_ALGORITHMS_SHA1_RC2_40 = "PBEWITHSHA1ANDRC2_40";

    private static PooledPBEStringEncryptor encryptor;
    private static final String password = "salt";

    private JasyptUtil() {
    }

    static {
        encryptor = new PooledPBEStringEncryptor();
        // 加解密盐值
        encryptor.setConfig(getConfig(password));
    }


    /**
     * Jasypt 加密
     *
     * @param encryptedStr 加密字符串
     * @return
     */
    public static String encrypt(String encryptedStr) {
        // 加密
        return encryptor.encrypt(encryptedStr);
    }

    /**
     * Jasypt 解密
     *
     * @param decryptStr 解密字符串
     * @return
     */
    public static String decrypt(String decryptStr) {
        // 解密
        return encryptor.decrypt(decryptStr);
    }

    /**
     * algorithm  指定解密算法：解密算法要与加密算法一一对应
     * PBE ALGORITHMS: [PBEWITHMD5ANDDES, PBEWITHMD5ANDTRIPLEDES, PBEWITHSHA1ANDDESEDE, PBEWITHSHA1ANDRC2_40]
     *
     */
    public static SimpleStringPBEConfig getConfig(String password) {
        SimpleStringPBEConfig config = new SimpleStringPBEConfig();
        // 加密盐值
        config.setPassword(password);
        // 加解密算法
        config.setAlgorithm(PBE_ALGORITHMS_MD5_DES);
        // 设置密钥获取迭代次数
        config.setKeyObtentionIterations(1000);
        // 线程池大小：默认1
        config.setPoolSize(1);
        // 盐值生成器className
        config.setSaltGeneratorClassName("org.jasypt.salt.RandomSaltGenerator");
        //  iv(initialization vector，初始化向量) 生成器className
        config.setIvGeneratorClassName("org.jasypt.iv.NoIvGenerator");
        // 设置字符串输出类型
        config.setStringOutputType("base64");
        return config;
    }

    public static void main(String[] args) {
        String encryptedStr = "password";
        String str = encryptor.encrypt(encryptedStr);
        System.out.println("加密后的字符串：" + str);
        System.out.println("解密后的字符串：" + JasyptUtil.decrypt("ENC@2YKSg4iC8J6ROcJDFNNJxnDR8yh9oHdP9CTRuW+8bm1s1QOPaECKng6rFs7TI5fb"));
    }
}
