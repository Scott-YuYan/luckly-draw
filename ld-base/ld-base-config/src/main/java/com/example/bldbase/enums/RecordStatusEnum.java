package com.example.bldbase.enums;

import lombok.Getter;

/**
 * @author J3（about：https://j3code.cn）
 * @package cn.j3code.luckydomain.record
 * @createTime 2022/12/9 - 23:06
 * @description
 */
@Getter
public enum RecordStatusEnum {

    STATUE_0(0, "用户不可见"),

    STATUE_1(1, "待领取奖品"),

    STATUE_2(2, "待运营人员确认"),

    STATUE_3(3, "待用户签收"),

    STATUE_4(4, "流程结束"),

    ;
    private Integer value;

    private String description;


    RecordStatusEnum(Integer value, String description){
        this.value = value;
        this.description = description;
    }

}
