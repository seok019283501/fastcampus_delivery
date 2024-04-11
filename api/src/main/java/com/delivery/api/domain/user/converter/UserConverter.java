package com.delivery.api.domain.user.converter;

import com.delivery.api.common.annotation.Converter;
import com.delivery.api.common.error.ErrorCode;
import com.delivery.api.common.exception.ApiException;
import com.delivery.api.domain.user.controller.model.UserRegisterRequest;
import com.delivery.api.domain.user.controller.model.UserResponse;
import com.delivery.db.user.UserEntity;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@Converter
@RequiredArgsConstructor
public class UserConverter {

    public UserEntity toEntity(UserRegisterRequest userRegisterRequest){
        return Optional.ofNullable(userRegisterRequest)
                .map(it->{
                    // to entity
                    return UserEntity.builder()
                            .name(userRegisterRequest.getName())
                            .email(userRegisterRequest.getEmail())
                            .password(userRegisterRequest.getPassword())
                            .address(userRegisterRequest.getAddress())
                            .build();
                }).orElseThrow(()->new ApiException(ErrorCode.NULL_POINT,"UserRegisterRequest Null"));
    }

    public UserResponse toResponse(UserEntity userEntity) {
        return Optional.ofNullable(userEntity)
                .map(it->{
                    System.out.println(userEntity.getUnregisteredAt());
                    return UserResponse.builder()
                            .id(userEntity.getId())
                            .name(userEntity.getName())
                            .status(userEntity.getStatus())
                            .email(userEntity.getEmail())
                            .address(userEntity.getAddress())
                            .registeredAt(userEntity.getRegisteredAt())
                            .unregisteredAt(userEntity.getUnregisteredAt())
                            .lastLoginAt(userEntity.getLastLoginAt())
                            .build();
                }).orElseThrow(()->new ApiException(ErrorCode.NULL_POINT,"UserEntity null"));
    }
}
