package com.example.app.user.query;

import com.alibaba.cola.exception.SysException;
import com.example.app.activity.RedisDeductionAwardNumberDrawExe;
import com.example.app.assembler.UserAssembler;
import com.example.client.dto.data.UserVO;
import com.example.client.dto.query.UserLoginQuery;
import com.example.domain.gateway.UserGateway;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Slf4j
@Component
@AllArgsConstructor
public class UserLoginQueryCmdExe {

    private final UserGateway userGateway;

    public RedisDeductionAwardNumberDrawExe redisDeductionAwardNumberDrawExe;


    public UserVO execute(UserLoginQuery query) {
        // 根据账号查询用户
        final var userEntity = userGateway.findByUserName(null, query.getUsername());

        // 不存在报错
        if (Objects.isNull(userEntity)){
            throw new SysException("登录失败，用户不存在！");
        }

        // 判断用户密码
        if (Boolean.FALSE.equals(userEntity.getPassword().isEqual(query.getPassword()))){
            throw new SysException("登录失败，密码错误！");
        }
        redisDeductionAwardNumberDrawExe.loginBefore(userEntity.getUsername());
        return UserAssembler.toUserVO(userEntity);
    }
}
