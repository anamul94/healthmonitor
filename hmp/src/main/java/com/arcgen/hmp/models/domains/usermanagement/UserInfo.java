/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.arcgen.hmp.models.domains.usermanagement;

import javax.persistence.*;


@Entity
@Table(name = "UserInfo")
public class UserInfo {
    @Id
    @Column(name="userInfoId")
    private String userInfoId;
    
    @Column(name="userEmail")
    private String userEmail;
    
    @Column(name="userName")
    private String userName;
    
    @Column(name="userPhone")
     private String userPhone;
    
    @Column(name="userAddress")
      private String userAddress;
    
    @Column(name="userDob")
       private String userDob;

    @Column(name = "userAuthenticationInfoId")
    private String userAuthenticationInfoId;
    
    public String getUserInfoId() {
        return userInfoId;
    }

    public void setUserInfoId(String userInfoId) {
        this.userInfoId = userInfoId;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public String getUserDob() {
        return userDob;
    }

    public void setUserDob(String userDob) {
        this.userDob = userDob;
    }

    public String getUserAuthenticationInfoId() {
        return userAuthenticationInfoId;
    }

    public void setUserAuthenticationInfoId(String userAuthenticationInfoId) {
        this.userAuthenticationInfoId = userAuthenticationInfoId;
    }

    
    
}
