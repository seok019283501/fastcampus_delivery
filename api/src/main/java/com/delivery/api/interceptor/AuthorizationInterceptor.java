package com.delivery.api.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.resource.ResourceHttpRequestHandler;

@Slf4j
@RequiredArgsConstructor
@Component
public class AuthorizationInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("Authorization Interceptor url : {}",request.getRequestURI());
        //WEB, chrom의경우 get,post options로 해당 api를 지원하는지 확인하는 기능이 있다.
        if(HttpMethod.OPTIONS.matches(request.getMethod())){
            return true;
        }
        if(handler instanceof ResourceHttpRequestHandler){
            return true;
        }
        //TODO header 검증
        return true;
    }
}
