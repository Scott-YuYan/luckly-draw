package com.example.app.user.command;

import com.example.app.assembler.UserAssembler;
import com.example.client.dto.UserUpdateCmd;
import com.example.client.dto.data.UserVO;
import com.example.domain.gateway.UserGateway;
import com.example.domain.user.UserEntity;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@AllArgsConstructor
public class UserUpdateCmdExe {
    private final UserGateway userGateway;

    public UserVO execute(UserUpdateCmd cmd) {
        UserEntity save = userGateway.save(UserAssembler.toUpdateEntity(cmd));
        return UserAssembler.toUserVO(save);
    }
}
