package com.example.infrastructure.gateway.impl.dataobject;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 领奖记录表
 * @TableName ld_accept_prize
 */
@TableName(value ="ld_accept_prize")
@Data
public class AcceptPrizeDB implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 抽奖记录id
     */
    private Long recordId;

    /**
     * 电话
     */
    private String phone;

    /**
     * 地址
     */
    private String address;

    /**
     * 
     */
    private Date createTime;

    /**
     * 
     */
    private String creator;

    /**
     * 
     */
    private Date updateTime;

    /**
     * 
     */
    private String updater;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}