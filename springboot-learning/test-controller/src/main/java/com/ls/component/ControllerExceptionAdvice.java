package com.ls.component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ls.common.anno.NotControllerResponseAdvice;
import com.ls.common.api.ResultCode;
import com.ls.vo.ResultVo;
import com.ls.exception.APIException;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

@RestControllerAdvice(basePackages = {"com.ls"})
public class ControllerExceptionAdvice implements ResponseBodyAdvice<Object> {

    @ExceptionHandler({BindException.class})
    public ResultVo MethodArgumentNotValidExceptionHandler(BindException e){
        // 从异常对象中拿到ObjectError对象
        ObjectError objectError = e.getBindingResult().getAllErrors().get(0);
        return new ResultVo(ResultCode.VALIDATE_ERROR,objectError.getDefaultMessage());
    }

    @ExceptionHandler(APIException.class)
    public ResultVo APIExceptionHandler(APIException e){
        //todo 日志记录
        return new ResultVo(e.getCode(),e.getMsg(),e.getMessage());
    }

    @Override
    public boolean supports(MethodParameter methodParameter, Class<? extends HttpMessageConverter<?>> aClass) {
        // response是ResultVo类型，或者注释了NotControllerResponseAdvice都不进行包装
        return !(methodParameter.getParameterType().isAssignableFrom(ResultVo.class)
                || methodParameter.hasMethodAnnotation(NotControllerResponseAdvice.class));
    }

    @Override
    public Object beforeBodyWrite(Object data, MethodParameter returnType, MediaType mediaType, Class<? extends HttpMessageConverter<?>> aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        // String类型不能直接包装
        if(returnType.getGenericParameterType().equals(String.class)){
            ObjectMapper objectMapper = new ObjectMapper();
            try {
                return objectMapper.writeValueAsString(new ResultVo(data));
            } catch (JsonProcessingException e) {
                throw new APIException(ResultCode.RESPONSE_PACK_ERROR,e.getMessage());
            }
        }
        // 否则直接包装成ResultVo返回
        return new ResultVo(data);
    }
}
