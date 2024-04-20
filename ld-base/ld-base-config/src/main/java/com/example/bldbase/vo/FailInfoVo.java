package com.example.bldbase.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

/**
 * 响应失败对象
 */
@Builder
@Getter
@ToString
public class FailInfoVo extends ResponseVo {

    public static final Integer DEFAULT_CODE = 500;
    public static final String DEFAULT_MESSAGE = "操作失败";

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String exception;

    protected FailInfoVo(String exception) {
        super(false, DEFAULT_CODE, DEFAULT_MESSAGE);
        this.exception = exception;
    }

    public FailInfoVo(Integer code, String exception) {
        super(false, code, DEFAULT_MESSAGE);
        this.exception = exception;
    }
}
