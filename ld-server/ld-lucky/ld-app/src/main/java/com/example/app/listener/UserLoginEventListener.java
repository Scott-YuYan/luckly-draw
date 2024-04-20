package com.example.app.listener;

import com.example.app.listener.event.UserLoginEvent;
import com.example.app.listener.eventPublish.UserLoginEventPublisher;
import com.example.client.dto.query.UserLoginQuery;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class UserLoginEventListener {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserLoginEventPublisher.class);

    /**
     * 异步执行，async注解
     * 登录事件监听器
     */
    @EventListener(classes = UserLoginEvent.class)
    public void dispatch(UserLoginEvent userLoginEvent){
        LOGGER.info("监听到登录事件event:{}", userLoginEvent);
        // 模拟异步场景
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        UserLoginQuery userLoginQuery = (UserLoginQuery)userLoginEvent.getConsumer();
        LOGGER.info("监听到的事件内容时：{}",userLoginQuery);
        LOGGER.info("登录事件监听完成");
    }
}
