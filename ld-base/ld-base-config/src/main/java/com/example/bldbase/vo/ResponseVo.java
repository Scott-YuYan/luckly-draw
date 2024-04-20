package com.example.bldbase.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;

import java.io.Serializable;

/**
 * 统一结果集返回对象
 */
@Getter
public class ResponseVo implements Serializable {

    protected Boolean result;
    protected Integer code;
    /**
     * mess为空时，不参与序列化
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    protected String message;

    protected ResponseVo(Boolean result, Integer code, String message) {
        this.result = result;
        this.code = code;
        this.message = message;
    }
}
