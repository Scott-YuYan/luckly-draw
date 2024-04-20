package com.example.bldbase.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;


/**
 * 响应成功对象
 */
@Builder
@Getter
@ToString
public class SuccessInfoVo extends ResponseVo {

    protected static final Integer DEFAULT_CODE = 200;
    protected static final String DEFAULT_MESSAGE = "操作成功";

    @JsonInclude(JsonInclude.Include.NON_NULL)
    protected Object data;


    protected SuccessInfoVo(Object data) {
        super(true, DEFAULT_CODE, DEFAULT_MESSAGE);
        this.data = data;
    }
}
