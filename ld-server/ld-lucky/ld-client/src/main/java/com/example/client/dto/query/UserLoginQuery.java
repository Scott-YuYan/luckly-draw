package com.example.client.dto.query;

import com.alibaba.cola.dto.Query;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class UserLoginQuery extends Query {

    @NotNull(message = "账号不为空")
    private String username;

    @NotNull(message = "密码不为空")
    private String password;
}
