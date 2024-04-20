package com.example.client.dto.data;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UserVO {
    /**
     *
     */
    private Long id;

    /**
     * 账号
     */
    private String username;


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
