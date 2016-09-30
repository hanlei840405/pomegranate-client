package com.fruit.service.client;

import com.fruit.converter.AccountConverter;
import com.fruit.dto.AccountDTO;
import com.fruit.entity.Account;
import com.fruit.manager.AccountManager;
import com.fruit.service.AccountLocalService;
import com.fruit.service.api.AccountRemoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hanlei6 on 2016/7/14.
 */
@Service("accountService")
public class AccountServiceImpl implements AccountLocalService, AccountRemoteService {

    @Autowired
    private AccountManager accountManager;

    @Override
//    @Cacheable(cacheNames = "mdc:account:id", key = "'/accountService/localGet/'.concat(#id)")
    public AccountDTO remoteGet(String id) {
        return AccountConverter.convertDTO(accountManager.get(id));
    }

    @Override
//    @Cacheable(cacheNames = "mdc:account:username", key = "'/accountService/localGetByUsername/'.concat(#username)")
    public AccountDTO remoteGetByUsername(String username) {
        return AccountConverter.convertDTO(accountManager.getByUsername(username));
    }

    @Override
    public Page<AccountDTO> localPage(Pageable pageable, String corporationId) {
        Page<Account> page = accountManager.page(pageable, corporationId);
        Converter<Account, AccountDTO> converter = account -> AccountConverter.convertDTO(account);
        return page.map(converter);
    }

    @Override
    public AccountDTO insert(AccountDTO account) {
        return AccountConverter.convertDTO(accountManager.save(AccountConverter.convertEntity(account)));
    }

    @Override
    public AccountDTO update(AccountDTO account) {
        return AccountConverter.convertDTO(accountManager.save(AccountConverter.convertEntity(account)));
    }

    @Override
    public AccountDTO delete(AccountDTO account) {
        return AccountConverter.convertDTO(accountManager.save(AccountConverter.convertEntity(account)));
    }

    @Override
    public void batchDelete(List<AccountDTO> accounts) {
        List<Account> accountList = new ArrayList<>();
        accounts.forEach(account -> accountList.add(AccountConverter.convertEntity(account)));
        accountManager.batch(accountList);
    }
}
