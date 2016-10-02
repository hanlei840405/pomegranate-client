package com.fruit.pomegranate.model;


import com.fruit.pomegranate.entity.Account;
import com.fruit.pomegranate.entity.Corporation;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

/**
 * Created by hanlei6 on 2016/9/1.
 */

@StaticMetamodel(Account.class)
public class Account_ {

    public static volatile SingularAttribute<Account, Corporation> corporation;
}
