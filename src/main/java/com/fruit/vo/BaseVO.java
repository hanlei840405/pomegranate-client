package com.fruit.vo;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by hanlei6 on 2016/9/9.
 */
@Setter
@Getter
public class BaseVO implements Serializable {
    private String id;

    private String status;

    private Date created;

    private String creator;

    private Date modified;

    private String modifier;

    private int version;
}
