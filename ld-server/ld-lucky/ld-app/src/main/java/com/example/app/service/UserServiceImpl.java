package com.example.app.service;

import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.app.listener.eventPublish.UserLoginEventPublisher;
import com.example.app.user.command.UserRegisterCmdExe;
import com.example.app.user.command.UserUpdateCmdExe;
import com.example.app.user.query.UserListByParamQueryExe;
import com.example.app.user.query.UserLoginQueryCmdExe;
import com.example.bldbase.exception.BldException;
import com.example.bldbase.utils.JwtUtil;
import com.example.bldbase.utils.SecurityUtil;
import com.example.client.api.UserService;
import com.example.client.dto.UserRegisterCmd;
import com.example.client.dto.UserUpdateCmd;
import com.example.client.dto.data.UserVO;
import com.example.client.dto.query.UserListByParamQuery;
import com.example.client.dto.query.UserLoginQuery;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.net.http.HttpRequest;
import java.util.Map;

@Slf4j
@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    /**
     * 构造器注入
     */
    private final UserRegisterCmdExe userRegisterCmdExe;

    private final UserLoginQueryCmdExe userLoginQueryCmdExe;

    private final UserListByParamQueryExe userListByParamQueryExe;

    private final UserUpdateCmdExe userUpdateCmdExe;

    private UserLoginEventPublisher userLoginEventPublisher;


    @Override
    public UserVO register(UserRegisterCmd cmd) {
        return userRegisterCmdExe.execute(cmd);
    }

    @Override
    public String login(UserLoginQuery query) {
        userLoginEventPublisher.publishEvent(query);
        UserVO userVO = userLoginQueryCmdExe.execute(query);
        return JwtUtil.createToken(Map.of("username",userVO.getName(),
                "name",userVO.getName(),
                "phone",userVO.getPhone(),
                "userId",userVO.getId()));
    }

    @Override
    public IPage<UserVO> page(UserListByParamQuery query) {
        return userListByParamQueryExe.execute(query);
    }

    @Override
    public UserVO one(Long id) {
        log.info("当前登陆用户：" + SecurityUtil.getUserName());
        final var query = new UserListByParamQuery();
        query.setId(id);
        IPage<UserVO> iPage = userListByParamQueryExe.execute(query);

        if (CollUtil.isEmpty(iPage.getRecords())) {
            throw new BldException("该用户不存在！");
        }
        return iPage.getRecords().get(0);

    }

    @Override
    public UserVO update(UserUpdateCmd cmd) {
        return userUpdateCmdExe.execute(cmd);
    }
}
