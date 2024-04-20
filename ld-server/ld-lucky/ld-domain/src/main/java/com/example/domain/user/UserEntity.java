package com.example.domain.user;

import com.alibaba.cola.domain.Entity;
import lombok.Data;
import org.springframework.context.annotation.Scope;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Data
public class UserEntity {

    /*
    这是个领域对象，所以该对象包含了，用户该有的基本功能
    1、校验用户名
    2、加密密码
    3、判断密码是否相等
     */

    /**
     *
     */
    private Long id;

    /**
     * 账号
     */
    @NotNull(message = "用户名不能为空")
    private String username;

    /**
     * 密码
     */
    private PassWord password;

    /**
     * 姓名
     */
    private String name;

    /**
     * 电话
     */
    private String phone;

    /**
     *
     */
    private LocalDateTime createTime;

    /**
     *
     */
    private LocalDateTime updateTime;
}
