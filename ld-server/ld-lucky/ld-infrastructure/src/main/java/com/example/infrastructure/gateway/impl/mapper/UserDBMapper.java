package com.example.infrastructure.gateway.impl.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.client.dto.query.UserListByParamQuery;
import com.example.domain.user.UserEntity;
import com.example.infrastructure.gateway.impl.dataobject.UserDB;
import org.apache.ibatis.annotations.Param;

/**
* @author mr-yuyan
* @description 针对表【ld_user】的数据库操作Mapper
* @createDate 2023-07-05 21:41:44
* @Entity com.example.po.UserDB
*/
public interface UserDBMapper extends BaseMapper<UserDB> {

    UserDB findByUserName(@Param("id") Long id, @Param("username") String username);

    IPage<UserDB> listByParamQuery(@Param("page") Page<UserEntity> userEntityPage, @Param("query") UserListByParamQuery query);
}




