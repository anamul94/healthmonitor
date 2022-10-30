/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.arcgen.hmp.models.domains.usermanagement;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="UserAuthenticationInfo")
public class UserAuthenticationInfo {
   @Id
    @Column(name = "userAuthenticationInfoId")
    private String userAuthenticationInfoId;
    
    @Column(name = "userEmail")
    private String userEmail;
    
    @Column(name = "userPassword")
    private String userPassword;

    public String getUserAuthenticationInfoId() {
        return userAuthenticationInfoId;
    }

    public void setUserAuthenticationInfoId(String userAuthenticationInfoId) {
        this.userAuthenticationInfoId = userAuthenticationInfoId;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }
    
    
    
}
