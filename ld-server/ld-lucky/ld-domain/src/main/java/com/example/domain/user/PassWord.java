package com.example.domain.user;

import cn.hutool.crypto.digest.MD5;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PassWord {

    private EncryptionPassWord encryptionPassWord;

    /**
     * 此构造方法传入的password为加密前的
     */
    public PassWord(String password) {
        this.encryptionPassWord = new EncryptionPassWord(getEncryptionPassWord(password));
    }

    /**
     * 此构造方法传入的为加密后的对象
     */
    public PassWord(EncryptionPassWord encryptionPassWord) {
        this.encryptionPassWord = encryptionPassWord;
    }

    public static String getEncryptionPassWord(String password) {
        return MD5.create().digestHex(password);
    }

    @Getter
    public static class EncryptionPassWord {

        private String password;

        public EncryptionPassWord(String password) {
            this.password = password;
        }
    }

    /**
     * 判断密码相等
     * @param password
     * @return
     */
    public Boolean isEqual(String password) {
        return this.encryptionPassWord.password.equals(getEncryptionPassWord(password));
    }
}