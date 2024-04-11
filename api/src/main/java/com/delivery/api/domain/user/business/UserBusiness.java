package com.delivery.api.domain.user.business;

import com.delivery.api.common.annotation.Business;
import com.delivery.api.common.api.Api;
import com.delivery.api.common.error.ErrorCode;
import com.delivery.api.common.exception.ApiException;
import com.delivery.api.domain.token.business.TokenBusiness;
import com.delivery.api.domain.token.controller.model.TokenResponse;
import com.delivery.api.domain.user.controller.model.UserLoginRequest;
import com.delivery.api.domain.user.controller.model.UserRegisterRequest;
import com.delivery.api.domain.user.controller.model.UserResponse;
import com.delivery.api.domain.user.converter.UserConverter;
import com.delivery.api.domain.user.service.UserService;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

// -> controller(그 외 헤더나 response에 관한 내용) -> business(여러가지 서비스를 가져다가 활용) -> service(domain login 처리) -> repository
@Business
@RequiredArgsConstructor
public class UserBusiness {
    private final UserService userService;
    private final UserConverter userConverter;
    private final TokenBusiness tokenBusiness;
    //사용자에 대한 가입 처리 로직
    //1. request -> entity
    //2. entity -> save
    public UserResponse register(UserRegisterRequest request) {
        var entity = userConverter.toEntity(request);
        var newEntity = userService.register(entity);
        var res = userConverter.toResponse(newEntity);
        return res;
//        return Optional.ofNullable(request)
//                .map(userConverter::toEntity)
//                .map(userService::register)
//                .map(userConverter::toResponse)
//                .orElseThrow(()->new ApiException(ErrorCode.NULL_POINT,"request null"));
    }

    //1. email, password를 가시고 사용자 체크
    //2. user entity 로그인 확인
    //3. token생성
    //4. token response
    public TokenResponse login(UserLoginRequest request) {
        var userEntity = userService.login(request.getEmail(), request.getPassword());
        //사용자가 없으면 throw

        //TODO 토큰생성 로직으로 변경하기
        var tokenResponse = tokenBusiness.issueToken(userEntity);
        return tokenResponse;
    }

    public UserResponse me(Long userId){
        var userEntity = userService.getUserWithThrow(userId);
        var response = userConverter.toResponse(userEntity);
        return response;
    }
}
