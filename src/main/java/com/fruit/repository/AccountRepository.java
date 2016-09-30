package com.fruit.repository;

import com.fruit.entity.Account;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * Created by hanlei6 on 2016/7/15.
 */
@Repository
public interface AccountRepository extends BaseRepository<Account, String>, JpaSpecificationExecutor {
    //    List<Account> findByMultiIds(Map<String, Object> params);
    Account findByUsername(String username);
}
