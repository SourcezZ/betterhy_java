package com.betterhy.common.db.dto;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * myapp_signin
 * @author 
 */
@Data
public class MyappSignin implements Serializable {
    private Integer id;

    private String signInTime;

    /**
     * 0未打 1已打 2异常
     */
    private String signInFlag;

    private String errorInfo;

    private Date createTime;

    private Date updateTime;

    private static final long serialVersionUID = 1L;
}