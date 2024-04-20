package com.example.app.user.command;

import com.alibaba.cola.exception.SysException;
import com.example.app.assembler.UserAssembler;
import com.example.client.dto.UserRegisterCmd;
import com.example.client.dto.data.UserVO;
import com.example.domain.gateway.UserGateway;
import com.example.domain.user.UserEntity;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Slf4j
@Component
@AllArgsConstructor
public class UserRegisterCmdExe {

    private final UserGateway userGateway;

    public UserVO execute(UserRegisterCmd cmd) {
        /*
        1、校验用户账号是否存在
        2、注册
         */
        UserEntity lodEntity = userGateway.findByUserName(null, cmd.getUsername());
        if (Objects.nonNull(lodEntity)) {
            throw new SysException("账号存在！");
        }
        UserEntity entity = userGateway.save(UserAssembler.toAddEntity(cmd));
        return UserAssembler.toUserVO(entity);
    }
}
