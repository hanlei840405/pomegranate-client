package com.fruit.pomegranate.service.client;

import com.fruit.pomegranate.converter.AccountConverter;
import com.fruit.pomegranate.dto.AccountDTO;
import com.fruit.pomegranate.entity.Account;
import com.fruit.pomegranate.manager.AccountManager;
import com.fruit.pomegranate.service.AccountLocalService;
import com.fruit.pomegranate.service.api.AccountRemoteService;
import com.fruit.strawberry.page.PageRequest;
import com.fruit.strawberry.page.PageResponse;
import org.springframework.beans.factory.annotation.Autowired;
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
    public PageResponse<AccountDTO> localPage(PageRequest pageRequest, String corporationId) {
        Pageable pageable = new org.springframework.data.domain.PageRequest(pageRequest.getPage(), pageRequest.getSize());
        Page<Account> page = accountManager.page(pageable, corporationId);
        List<AccountDTO> dtos = new ArrayList<>();
        page.getContent().forEach(account -> dtos.add(AccountConverter.convertDTO(account)));
        PageResponse<AccountDTO> pageResponse = new PageResponse<>(page.getTotalPages(), page.getNumberOfElements(), page.getNumber(), page.getSize(), dtos);
        return pageResponse;
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
