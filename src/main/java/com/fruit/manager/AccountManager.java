package com.fruit.manager;

import com.fruit.entity.Account;
import com.fruit.entity.Corporation;
import com.fruit.repository.AccountRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by hanlei6 on 2016/7/14.
 */
@Service
public class AccountManager {
    private final static Logger LOGGER = LoggerFactory.getLogger(AccountManager.class);
    @Autowired
    private AccountRepository accountRepository;

    @PersistenceContext
    private EntityManager entityManager;

    @Value("${batch.size}")
    private int batchSize;

    /**
     * 根据id查询账号
     *
     * @param id
     * @return
     */
    public Account get(String id) {
        return accountRepository.findOne(id);
    }

    public Account save(Account account) {
        return accountRepository.save(account);
    }

    @Transactional
    public void batch(List<Account> accounts) {
        for (int i = 0; i < accounts.size(); i++) {
            Account account = accounts.get(i);
            entityManager.merge(account);
            if (i % batchSize == 0) {
                entityManager.flush();
                entityManager.clear();
            }
        }
    }

    /**
     * 根据username查询账号
     *
     * @param username
     * @return
     */
    public Account getByUsername(String username) {
        return accountRepository.findByUsername(username);
    }

    public Page<Account> page(Pageable pageable, String corporationId) {
        Account accountQuery = new Account();
        Corporation corporationQuery = new Corporation();
        corporationQuery.setId(corporationId);
        accountQuery.setCorporation(corporationQuery);
        Example<Account> example = Example.of(accountQuery);
        Page<Account> page = accountRepository.findAll(example, pageable);
        return page;
    }

}
