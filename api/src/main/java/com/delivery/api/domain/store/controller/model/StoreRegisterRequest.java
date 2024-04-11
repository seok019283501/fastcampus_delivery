package com.delivery.api.domain.store.controller.model;

import com.delivery.db.store.enums.StoreCategory;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StoreRegisterRequest {
    @NotBlank
    private String name;
    @NotBlank //"", " ", null X
    private String address;
    @NotNull // null X
    private StoreCategory storeCategory;
    @NotBlank
    private String thumbnailUrl;
    @NotNull
    private BigDecimal minimumAmount;
    @NotNull
    private BigDecimal mininumDeliveryAmount;
    @NotBlank
    private String phoneNumber;
}
