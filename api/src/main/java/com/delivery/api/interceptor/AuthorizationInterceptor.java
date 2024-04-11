package com.delivery.api.interceptor;

import com.delivery.api.common.error.ErrorCode;
import com.delivery.api.common.error.TokenErrorCode;
import com.delivery.api.common.exception.ApiException;
import com.delivery.api.domain.token.business.TokenBusiness;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.http.fileupload.RequestContext;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.resource.ResourceHttpRequestHandler;

import java.util.Objects;

@Slf4j
@RequiredArgsConstructor
@Component
public class AuthorizationInterceptor implements HandlerInterceptor {
    private final TokenBusiness tokenBusiness;

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
        var accessToken = request.getHeader("authorization-token");
        System.out.println(accessToken);
        if(accessToken == null){
            throw new ApiException(TokenErrorCode.AUTHORIZATION_TOKEN_NOT_FOUNT);
        }
        var userId = tokenBusiness.validationAccessToken(accessToken);
        if(userId != null){
            var requestContext = Objects.requireNonNull(RequestContextHolder.getRequestAttributes());
            requestContext.setAttribute("userId",userId, RequestAttributes.SCOPE_REQUEST);
            return true;
        }
        throw new ApiException(ErrorCode.BAD_REQUEST,"인증 실패");
    }
}
