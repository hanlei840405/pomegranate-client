package com.fruit.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import java.io.Serializable;

/**
 * Created by hanlei6 on 2016/7/14.
 */
@Entity(name = "mdc_account")
@Setter
@Getter
public class Account extends BaseEntity implements Serializable {
    private static final long serialVersionUID = -5620076148355923176L;

    private String username;

    private String password;

    @ManyToOne(fetch = FetchType.LAZY)
    private Corporation corporation;
}
