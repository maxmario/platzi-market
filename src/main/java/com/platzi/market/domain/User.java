package com.platzi.market.domain;

public class User {
    
    private int userId;
    private String userName;
    private String userPass;
    private boolean active;
    
    public int getUserId() {
        return userId;
    }
    public void setUserId(int userId) {
        this.userId = userId;
    }
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getUserPass() {
        return userPass;
    }
    public void setUserPass(String userPass) {
        this.userPass = userPass;
    }
    public boolean isActive() {
        return active;
    }
    public void setActive(boolean active) {
        this.active = active;
    }

    
}
