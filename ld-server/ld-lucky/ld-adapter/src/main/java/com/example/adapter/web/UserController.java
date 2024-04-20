package com.example.adapter.web;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.bldbase.utils.SecurityUtil;
import com.example.client.api.UserService;
import com.example.client.dto.UserRegisterCmd;
import com.example.client.dto.UserUpdateCmd;
import com.example.client.dto.data.UserVO;
import com.example.client.dto.query.UserListByParamQuery;
import com.example.client.dto.query.UserLoginQuery;
import com.example.common.annotation.ResponseResult;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Slf4j
@AllArgsConstructor
@ResponseResult
@RequestMapping("/v1/user")
public class UserController {

    private final UserService userService;

    @PostMapping("/register")
    public UserVO register(@Validated @RequestBody UserRegisterCmd cmd) {
        return userService.register(cmd);
    }


    @PostMapping("/login")
    public String login(@Validated @RequestBody UserLoginQuery query) {
        return userService.login(query);
    }

    @GetMapping("/one")
    public UserVO one(@RequestParam(value = "id") Long id) {
        return userService.one(id);
    }

    @GetMapping("/me")
    public UserVO me() {
        return userService.one(SecurityUtil.getUserId());
    }

    @PostMapping("/update")
    public UserVO update(@Validated @RequestBody UserUpdateCmd cmd) {
        return userService.update(cmd);
    }
}
