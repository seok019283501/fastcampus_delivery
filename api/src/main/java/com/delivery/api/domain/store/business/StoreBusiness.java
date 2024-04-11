package com.delivery.api.domain.store.business;

import com.delivery.api.common.annotation.Business;
import com.delivery.api.domain.store.controller.model.StoreRegisterRequest;
import com.delivery.api.domain.store.controller.model.StoreResponse;
import com.delivery.api.domain.store.converter.StoreConverter;
import com.delivery.api.domain.store.service.StoreService;
import com.delivery.db.store.enums.StoreCategory;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Business
public class StoreBusiness {
    private final StoreService storeService;
    private final StoreConverter storeConverter;

    //등록
    public StoreResponse register(StoreRegisterRequest storeRegisterRequest){
        var entity = storeConverter.toEntity(storeRegisterRequest);
        var newEntity = storeService.register(entity);
        var res = storeConverter.toResponse(newEntity);
        return res;
    }

    public List<StoreResponse> searchCategory(StoreCategory storeCategory){
        var storeList = storeService.searchByCategory(storeCategory);
        //entity의 내용이 response로 변환한 list로 변환이 된다.
        return storeList.stream()
                .map(storeConverter::toResponse)
                .collect(Collectors.toList());
    }

}
