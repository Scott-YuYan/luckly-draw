package com.example.app.activity;


import cn.hutool.json.JSONUtil;
import com.example.bldbase.utils.FileLoadUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.data.redis.core.script.RedisScript;
import org.springframework.stereotype.Component;
import org.springframework.transaction.support.TransactionTemplate;

import java.util.List;
import java.util.Objects;

@Slf4j
@Component
public class RedisDeductionAwardNumberDrawExe extends DefaultDrawExe {

    private final RedisTemplate<String, Object> redisTemplate;


    private static String stockDeductionLua;

    static {
        RedisDeductionAwardNumberDrawExe.stockDeductionLua = FileLoadUtil.read("lua/stock_deduction.lua");
    }

    public RedisDeductionAwardNumberDrawExe(TransactionTemplate transactionTemplate,RedisTemplate<String, Object> redisTemplate) {
        super(transactionTemplate);
        this.redisTemplate = redisTemplate;
    }


    @Override
    public Boolean loginBefore(String userName) {
        Integer loginLua = invokeStockDeductionLua(userName);
        log.info("loginBefore 执行结果：" + loginLua);
        if (loginLua != 1){
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }


    /**
     * 执行Lua脚本
     *
     * @return
     */
    public Integer invokeStockDeductionLua(String key) {
        log.info("stockDeductionLua;" + stockDeductionLua);
        RedisScript<Long> redisScript = new DefaultRedisScript<>(stockDeductionLua, Long.class);
        log.info("redisScript:" + JSONUtil.toJsonStr(redisScript));
        Long execute = redisTemplate.opsForValue().getOperations().execute(redisScript, List.of(key));
        log.info("execute:"+ execute);
        if (Objects.isNull(execute) || execute == -1){
            return 0;
        }
        return 1;
    }
}
