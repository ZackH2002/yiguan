package com.yiguan.entity;

public class User {
    private int id;
    private String username;
    private String password;
    private int authority;
    private int depository_id;

    public User() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAuthority() {
        return authority;
    }

    public void setAuthority(int authority) {
        this.authority = authority;
    }

    public int getDepository_id() {
        return depository_id;
    }

    public void setDepository_id(int depository_id) {
        this.depository_id = depository_id;
    }
}
