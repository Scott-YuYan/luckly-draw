package com.example.common.handler;

import com.example.bldbase.exception.BldException;
import com.example.bldbase.exception.NotAuthException;
import com.example.bldbase.vo.FailInfoVo;
import com.mysql.cj.jdbc.exceptions.MysqlDataTruncation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Objects;

/**
 * 全局异常处理
 * 从上往下适配
 */
@Slf4j
@RestControllerAdvice
public class SysExceptionHandler {

    /**
     * 全局异常处理
     */
    @ExceptionHandler(value = Exception.class)
    public FailInfoVo exception(Exception ex) {
        log.error("Exception_info:{}", ex.getMessage());
        log.error("Exception_info:", ex);
        return FailInfoVo.builder().exception(ex.getMessage()).build();
    }


    /**
     * 参数绑定错误
     */
    @ExceptionHandler(value = BindException.class)
    public FailInfoVo exception(BindException ex) {
        String defaultMessage = Objects.requireNonNull(ex.getBindingResult().getFieldError()).getDefaultMessage();
        log.error("Exception_info:{}", defaultMessage);
        log.error("Exception_info:", ex);
        return FailInfoVo.builder().exception(defaultMessage).build();
    }


    @ExceptionHandler(value = BldException.class)
    public FailInfoVo sysException(Exception ex) {
        log.error("Exception_info:{}", ex.getMessage());
        log.error("Exception_info:", ex);
        return FailInfoVo.builder().exception(ex.getMessage()).build();
    }

    @ExceptionHandler(value = NotAuthException.class)
    public FailInfoVo notAuthException(Exception ex) {
        log.error("Exception_info:{}", ex.getMessage());
        log.error("Exception_info:", ex);
        return new FailInfoVo(401, ex.getMessage());
    }

    /**
     * 数据转换异常
     */
    @ExceptionHandler(value = MysqlDataTruncation.class)
    public FailInfoVo mysqlDataTruncation(Exception ex) {
        log.error("Exception_info:{}", ex.getMessage());
        log.error("Exception_info:", ex);
        return new FailInfoVo(500, ex.getMessage());
    }

    /**
     * 插入或更新数据库数据时，新数据违反了数据完整性异常
     */
    @ExceptionHandler(value = DataIntegrityViolationException.class)
    public FailInfoVo dataIntegrityViolationException(Exception ex) {
        log.error("Exception_info:{}", ex.getMessage());
        log.error("Exception_info:", ex);
        String message = ex.getMessage();
        String[] split = message.split("\r\n###");
        for (String str : split) {
            if (str.trim().isBlank() || str.trim().contains("Error")) {
                continue;
            }
            String[] split1 = str.split(":");
            if (split1.length > 0) {
                message = split1[split1.length - 1].trim();
            }
        }
        return new FailInfoVo(500, message);
    }
}
