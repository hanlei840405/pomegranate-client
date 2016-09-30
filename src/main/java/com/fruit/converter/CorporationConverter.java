package com.fruit.converter;

import com.fruit.dto.AccountDTO;
import com.fruit.dto.CorporationDTO;
import com.fruit.entity.Account;
import com.fruit.entity.Corporation;
import org.springframework.beans.BeanUtils;

/**
 * Created by hanlei6 on 2016/9/30.
 */
public class CorporationConverter {

    public static CorporationDTO convertDTO(Corporation corporation) {
        CorporationDTO corporationDTO = new CorporationDTO();
        BeanUtils.copyProperties(corporation, corporationDTO, "accounts");
        corporation.getAccounts().forEach(account -> {
            AccountDTO accountDTO = new AccountDTO();
            BeanUtils.copyProperties(account, accountDTO, "corporation");
        });
        return corporationDTO;
    }

    public static Corporation convertEntity(CorporationDTO corporationDTO) {
        Corporation corporation = new Corporation();
        BeanUtils.copyProperties(corporationDTO, corporation, "accounts");
        return corporation;
    }
}
