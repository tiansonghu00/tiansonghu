package com.tian.qqcommon;

import java.io.Serializable;

public class User implements Serializable {
    //表示一个用户/客户信息
    private String userId;
    private String passwd;
    private static final long serialVersionUID = 1L;

    public User(String userId, String passwd) {
        this.userId = userId;
        this.passwd = passwd;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }
}
