package com.example.app.listener.eventPublish;

import com.alibaba.fastjson.JSON;
import com.example.app.listener.event.UserLoginEvent;
import lombok.NonNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Component;

@Component
public class UserLoginEventPublisher implements ApplicationEventPublisherAware, ApplicationContextAware {

    /**
     * 日志管理组件
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(UserLoginEventPublisher.class);

    /**
     * 上下文容器
     */
    private ApplicationContext applicationContext;

    /**
     * 事件发布组件
     */
    private ApplicationEventPublisher applicationEventPublisher;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    @Override
    public void setApplicationEventPublisher(@NonNull ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }

    /**
     * 广播📢{@link UserLoginEventPublisher}事件
     *
     * @param t 消费者
     */
    public <T> void publishEvent(T t) {
        LOGGER.info("消费者事件发布开始，参数:{}", JSON.toJSONString(t));
        UserLoginEvent event = new UserLoginEvent(applicationContext);
        event.setConsumer(t);
        applicationEventPublisher.publishEvent(event);
        LOGGER.info("事件发布结束");
        LOGGER.info("broadcast FirstLogonEvent");
    }

}
