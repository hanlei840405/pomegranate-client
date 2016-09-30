package com.fruit.model;


import com.fruit.entity.Account;
import com.fruit.entity.Corporation;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

/**
 * Created by hanlei6 on 2016/9/1.
 */

@StaticMetamodel(Account.class)
public class Account_ {

    public static volatile SingularAttribute<Account, Corporation> corporation;
}
