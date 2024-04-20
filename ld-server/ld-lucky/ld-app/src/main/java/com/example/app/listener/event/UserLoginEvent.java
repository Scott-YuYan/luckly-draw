package com.example.app.listener.event;

import org.springframework.context.ApplicationEvent;

import javax.validation.constraints.NotNull;

public class UserLoginEvent<T> extends ApplicationEvent {

    /**
     * 实体
     */
    private T t;


    /**
     * Create a new {@code ApplicationEvent}.
     *
     * @param source the object on which the event initially occurred or with
     *               which the event is associated (never {@code null})
     */
    public UserLoginEvent(Object source,T t) {
        super(source);
        this.t = t;
    }

    public UserLoginEvent(@NotNull Object source) {
        super(source);
    }


    public T getConsumer() {
        return t;
    }

    public void setConsumer(T t) {
        this.t = t;
    }
}
