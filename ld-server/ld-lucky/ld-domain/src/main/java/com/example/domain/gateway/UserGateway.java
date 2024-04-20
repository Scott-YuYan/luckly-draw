package com.example.domain.gateway;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.client.dto.query.UserListByParamQuery;
import com.example.domain.user.UserEntity;

public interface UserGateway {

    UserEntity save(UserEntity entity);

    UserEntity findByUserName(Long id, String username);

    IPage<UserEntity> listByParamQuery(UserListByParamQuery query);

}
