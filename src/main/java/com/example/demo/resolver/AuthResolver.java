package com.example.demo.resolver;

import com.example.demo.common.auth.AuthParam;
import com.example.demo.common.auth.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

@Component
@RequiredArgsConstructor
public class AuthResolver implements HandlerMethodArgumentResolver {


    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        boolean isAnnotation = parameter.hasParameterAnnotation(AuthParam.class);
        boolean isType = parameter.getParameterType().equals(Member.class);
        return isAnnotation && isType;
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        // TODO 회원 세션 처리
        return Member
                .builder()
                .memberId(1)
                .nickname("몰라")
                .loginTypeCd("100123")
                .snsTypeCd("100123")
                .platformId(1)
                .platformNm("이벤트유앱")
                .build();
    }
}
