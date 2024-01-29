package com.example.demo.config;

import com.example.demo.annotation.AuthParam;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

@Configuration
public class CustomResolver implements HandlerMethodArgumentResolver {
    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.hasParameterAnnotation(AuthParam.class);
    }

    @Override
    public Integer resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {

        AuthParam customParam = parameter.getParameterAnnotation(AuthParam.class);
        //String value = webRequest.getParameter("auth");

        //TODO
        Integer memberId = 123123;
        return memberId;
    }
}
