package com.delivery.db.store.enums;

import lombok.AllArgsConstructor;

@AllArgsConstructor

public enum StoreCategory {
    //한식
    KOREAN_FOOD("한식","한식"),
    //중식
    CHINESE_FOOD("중식","중식"),
    //양식
    WESTERN_FOOD("양식","양식"),
    //일식
    JAPANESE_FOOD("일식","일식"),
    //카페
    CAFE("카페","카페"),
    //치킨
    CHICKEN("치킨","치킨"),
    //피자
    PIZZA("피자","피자"),
    //햄버거
    HAMBERGER("햄버거","햄버거")
    ;
    private String description;
    private String display;
}