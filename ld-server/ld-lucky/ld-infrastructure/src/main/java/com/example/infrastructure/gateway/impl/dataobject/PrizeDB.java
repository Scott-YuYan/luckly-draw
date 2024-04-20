package com.example.infrastructure.gateway.impl.dataobject;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 奖品表
 * @TableName ld_prize
 */
@TableName(value ="ld_prize")
@Data
public class PrizeDB implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 奖品名称
     */
    private String prizeName;

    /**
     * 库存
     */
    private Integer inventory;

    /**
     * 金额
     */
    private Integer money;

    /**
     * 类型（1：商品，2：金钱）
     */
    private Integer type;

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