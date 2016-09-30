package com.fruit.converter;

import com.fruit.dto.AccountDTO;
import com.fruit.dto.CorporationDTO;
import com.fruit.entity.Account;
import org.springframework.beans.BeanUtils;

/**
 * Created by hanlei6 on 2016/9/30.
 */
public class AccountConverter {
    public static AccountDTO convertDTO(Account account) {
        AccountDTO accountDTO = new AccountDTO();
        BeanUtils.copyProperties(account, accountDTO, "corporation");
        CorporationDTO corporationDTO = new CorporationDTO();
        BeanUtils.copyProperties(account.getCorporation(), corporationDTO, "accounts");
        accountDTO.setCorporation(corporationDTO);
        return accountDTO;
    }

    public static Account convertEntity(AccountDTO accountDTO) {
        Account account = new Account();
        BeanUtils.copyProperties(accountDTO, account, "corporation");
        return account;
    }
}
