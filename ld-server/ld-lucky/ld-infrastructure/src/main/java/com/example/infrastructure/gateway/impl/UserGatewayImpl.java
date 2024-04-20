package com.example.infrastructure.gateway.impl;

import com.alibaba.cola.exception.SysException;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.client.dto.query.UserListByParamQuery;
import com.example.domain.gateway.UserGateway;
import com.example.domain.user.UserEntity;
import com.example.infrastructure.convertor.UserConvertor;
import com.example.infrastructure.gateway.impl.dataobject.UserDB;
import com.example.infrastructure.gateway.impl.mapper.UserDBMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Slf4j
@Component
@AllArgsConstructor
public class UserGatewayImpl implements UserGateway {

    private final UserDBMapper userMapper;

    @Override
    public UserEntity save(UserEntity entity) {
        if (Objects.isNull(entity.getId())){
            return addUser(entity);
        }
        return updateUser(entity);
    }

    private UserEntity updateUser(UserEntity entity) {
        UserDB userDB = UserConvertor.toUserDB(entity);

        int update = userMapper.updateById(userDB);
        if (update <= 0) {
            throw new SysException("修改失败！");
        }
        return UserConvertor.toEntity(userDB);
    }

    private UserEntity addUser(UserEntity entity) {
        UserDB userDB = UserConvertor.toUserDB(entity);

        int insert = userMapper.insert(userDB);
        if (insert <= 0) {
            throw new SysException("注册失败！");
        }
        return UserConvertor.toEntity(userDB);
    }

    @Override
    public UserEntity findByUserName(Long id, String username) {
        UserDB userDB = userMapper.findByUserName(id, username);
        if (Objects.isNull(userDB)) {
            return null;
        }
        return UserConvertor.toEntity(userDB);
    }

    @Override
    public IPage<UserEntity> listByParamQuery(UserListByParamQuery query) {
        IPage<UserDB> userDBIPage = userMapper.listByParamQuery(new Page<>(query.getPageIndex(), query.getPageSize()), query);

        return userDBIPage.convert(UserConvertor::toEntity);
    }
}
