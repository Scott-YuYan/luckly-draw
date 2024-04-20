package com.example.common.handler;

import com.example.common.annotation.ResponseResult;
import com.example.bldbase.vo.SuccessInfoVo;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.MethodParameter;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import java.util.Objects;

@Slf4j
@RestControllerAdvice
@AllArgsConstructor
public class ResponseResultHandler implements ResponseBodyAdvice<Object> {

    /**
     * 判断是否增强
     *
     * @param returnType
     * @param converterType
     * @return
     */
    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        final var method = returnType.getMethod();
        final var klass = Objects.requireNonNull(method, "method is null").getDeclaringClass();
        ResponseResult annotation = klass.getAnnotation(ResponseResult.class);
        if (annotation == null) {
            annotation = method.getAnnotation(ResponseResult.class);
        }
        // 如果是文件流则不增强
        if (method.getAnnotatedReturnType().getType().getTypeName().equals(FileSystemResource.class.getTypeName())) {
            return false;
        }
        return annotation != null && !annotation.ignore();
    }

    @SneakyThrows
    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        var successInfo = SuccessInfoVo.builder().data(body).build();
        if ((body instanceof String) && !MediaType.APPLICATION_ATOM_XML_VALUE.equals(returnType.toString())) {
            ObjectMapper objectMapper = new ObjectMapper();
            response.getHeaders().set("Content-Type", MediaType.APPLICATION_JSON_VALUE);
            return objectMapper.writeValueAsString(successInfo);
        }
        if (Objects.isNull(body) && MediaType.TEXT_HTML_VALUE.equals(returnType.toString())) {
            ObjectMapper om = new ObjectMapper();
            response.getHeaders().set("Content-Type", "application/json");
            return om.writeValueAsString(successInfo);
        }
        return successInfo;
    }
}
