package com.delivery.api.account;

import com.delivery.api.account.model.AccountMeResponse;
import com.delivery.api.common.api.Api;
import com.delivery.api.common.error.UserErrorCode;
import com.delivery.db.account.AccountEntity;
import com.delivery.db.account.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/account")
public class AccountApiController {
    private final AccountRepository accountRepository;
    @GetMapping("/me")
    public Api<AccountMeResponse> me(){
        var res = AccountMeResponse.builder()
                .name("홍길동")
                .email("A@email.com")
                .registeredAt(LocalDateTime.now())
                .build();
        var str = "안녕하세요";
        var age = Integer.parseInt(str);
        return Api.OK(res);

    }

}
