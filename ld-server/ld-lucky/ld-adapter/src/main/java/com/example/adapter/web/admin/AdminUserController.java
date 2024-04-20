package com.example.adapter.web.admin;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.client.api.UserService;
import com.example.client.dto.data.UserVO;
import com.example.client.dto.query.UserListByParamQuery;
import com.example.common.annotation.ResponseResult;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Slf4j
@AllArgsConstructor
@ResponseResult
@RequestMapping("/admin/v1/user")
public class AdminUserController {

    private final UserService userService;

    @PostMapping("/page")
    public IPage<UserVO> page(@RequestBody UserListByParamQuery query) {
        return userService.page(query);
    }


    @PostMapping("/one")
    public UserVO one(@RequestParam(value = "id",required = false) Long id) {
        return userService.one(id);
    }
}
