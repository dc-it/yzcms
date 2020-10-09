package com.mapc.yzcms;

import com.mapc.yzcms.dto.SysUserLoginDto;
import com.mapc.yzcms.service.IAccountService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
class AccountTests {

    private IAccountService accountService;

    @Autowired
    public AccountTests(IAccountService accountService) {
        this.accountService = accountService;
    }

    @Test
    void testLogin() {
        SysUserLoginDto sysUserLoginDto = new SysUserLoginDto();
        sysUserLoginDto.setAccount("du17724847255@163.com");
        sysUserLoginDto.setPassword("duchao123");
        String token = accountService.login(sysUserLoginDto);
        log.info("登录Token：{}",token);
    }

}
