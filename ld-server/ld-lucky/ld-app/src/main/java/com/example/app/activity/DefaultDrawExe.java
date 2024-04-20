package com.example.app.activity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.support.TransactionTemplate;

@Getter
@Slf4j
@Component
@AllArgsConstructor
public class DefaultDrawExe {

    private final TransactionTemplate transactionTemplate;

    protected Boolean loginBefore(String userName){
        return null;
    };

}
