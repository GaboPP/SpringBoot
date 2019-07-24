package com.isw.server.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
 
@Entity
public class user {
 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private int user_id;
    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;
 
    public user() {
 
    }
 
    public user(int user_id, String username, String password) {
        this.user_id = user_id;
        this.username = username;
        this.password = password;
    }
 
    public int getUserId() {
        return user_id;
    }
 
    public void setUserId(int userId) {
        this.user_id = userId;
    }
 
    public String getUserName() {
        return username;
    }
 
    public void setUserName(String userName) {
        this.username = userName;
    }
 
    public String getEncrytedPassword() {
        return password;
    }
 
    public void setEncrytedPassword(String encrytedPassword) {
        this.password = encrytedPassword;
    }
 
    @Override
    public String toString() {
        return this.username + "/" + this.password;
    }
 
}