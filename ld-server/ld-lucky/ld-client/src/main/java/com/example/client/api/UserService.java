package com.example.client.api;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.client.dto.UserRegisterCmd;
import com.example.client.dto.UserUpdateCmd;
import com.example.client.dto.data.UserVO;
import com.example.client.dto.query.UserListByParamQuery;
import com.example.client.dto.query.UserLoginQuery;

public interface UserService {

    /**
     * 用户注册
     * @param cmd
     * @return
     */
    UserVO register(UserRegisterCmd cmd);

    /**
     * 用户登录
     * @param query
     * @return
     */
    String login(UserLoginQuery query);


    /**
     * 分页查询
     * @param query
     * @return
     */
    IPage<UserVO> page(UserListByParamQuery query);

    /**
     * 获取用户信息
     * @param id
     * @return
     */
    UserVO one(Long id);

    /**
     * 用户修改
     * @param cmd
     * @return
     */
    UserVO update(UserUpdateCmd cmd);
}
