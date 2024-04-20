package com.example.app.user.query;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.app.assembler.UserAssembler;
import com.example.client.dto.data.UserVO;
import com.example.client.dto.query.UserListByParamQuery;
import com.example.domain.gateway.UserGateway;
import com.example.domain.user.UserEntity;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@AllArgsConstructor
public class UserListByParamQueryExe {

    private final UserGateway userGateway;

    public IPage<UserVO> execute(UserListByParamQuery query) {
        IPage<UserEntity> entityIPage = userGateway.listByParamQuery(query);
        return entityIPage.convert(UserAssembler::toUserVO);
    }
}