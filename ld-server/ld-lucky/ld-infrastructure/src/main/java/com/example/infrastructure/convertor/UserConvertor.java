package com.example.infrastructure.convertor;
import java.time.LocalDateTime;

import com.example.domain.user.PassWord;
import com.example.domain.user.UserEntity;
import com.example.infrastructure.gateway.impl.dataobject.UserDB;

import java.util.Objects;

public class UserConvertor {

    public static UserDB toUserDB(UserEntity entity) {
        UserDB userDB = new UserDB();
        userDB.setId(entity.getId());
        userDB.setUsername(entity.getUsername());

        if (Objects.nonNull(entity.getPassword())){
            userDB.setPassword(entity.getPassword().getEncryptionPassWord().getPassword());
        }
        userDB.setName(entity.getName());
        userDB.setPhone(entity.getPhone());
        userDB.setCreateTime(entity.getCreateTime());
        // 根据登入人的name值设置
        userDB.setCreator("三哥");
        userDB.setUpdateTime(entity.getCreateTime());
        userDB.setUpdater("三哥");

        return userDB;
    }

    public static UserEntity toEntity(UserDB userDB) {
        UserEntity userEntity = new UserEntity();
        userEntity.setId(userDB.getId());
        userEntity.setUsername(userDB.getUsername());
        userEntity.setPassword(new PassWord(new PassWord.EncryptionPassWord(userDB.getPassword())));
        userEntity.setName(userDB.getName());
        userEntity.setPhone(userDB.getPhone());
        userEntity.setCreateTime(userDB.getCreateTime());
        userEntity.setUpdateTime(userDB.getUpdateTime());

        return userEntity;
    }
}
