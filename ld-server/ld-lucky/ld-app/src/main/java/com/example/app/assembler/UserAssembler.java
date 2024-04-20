package com.example.app.assembler;

import com.example.client.dto.UserRegisterCmd;
import com.example.client.dto.UserUpdateCmd;
import com.example.client.dto.data.UserVO;
import com.example.domain.user.PassWord;
import com.example.domain.user.UserEntity;

import java.time.LocalDateTime;
import java.util.Objects;

public class UserAssembler {

    public static UserEntity toAddEntity(UserRegisterCmd cmd) {
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername(cmd.getUsername());
        userEntity.setPassword(new PassWord(cmd.getPassword()));
        userEntity.setName(cmd.getName());
        userEntity.setPhone(cmd.getPhone());
        userEntity.setCreateTime(LocalDateTime.now());
        userEntity.setUpdateTime(LocalDateTime.now());
        return userEntity;
    }

    public static UserVO toUserVO(UserEntity entity) {
        UserVO userVO = new UserVO();
        userVO.setId(entity.getId());
        userVO.setUsername(entity.getUsername());
        userVO.setName(entity.getName());
        userVO.setPhone(entity.getPhone());
        userVO.setCreateTime(entity.getCreateTime());
        userVO.setUpdateTime(entity.getUpdateTime());

        return userVO;
    }

    public static UserEntity toUpdateEntity(UserUpdateCmd cmd) {
        UserEntity userEntity = new UserEntity();
        userEntity.setId(cmd.getId());
        userEntity.setUsername(cmd.getUsername());
        if (Objects.nonNull(cmd.getPassword())){
            userEntity.setPassword(new PassWord(cmd.getPassword()));
        }
        userEntity.setName(cmd.getName());
        userEntity.setPhone(cmd.getPhone());
        userEntity.setUpdateTime(LocalDateTime.now());
        return userEntity;
    }

}
