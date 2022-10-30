
package com.arcgen.hmp.models.domains.userhealthinfo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "UserDailyHealthMonitorInfo")
public class UserDailyHealthMonitorInfo {
    @Id
     @Column(name = "userDailyHealthMonitorInfoId")
    private String userDailyHealthMonitorInfoId;
    
    @Column(name = "userWeight")
    private String userWeight;
    
    @Column(name = "userBloodPressureSystolic")
    private String userBloodPressureSystolic;

    @Column(name = "userBloodPressureDiastolic")
    private String userBloodPressureDiastolic;

    @Column(name = "userPulse")
    private String userPulse;

    @Column(name = "userSpo2")
    private String userSpo2;

    @Column(name = "userTemperature")
    private String userTemperature;
    
    @Column(name = "dateTime")
    private String dateTime;
    
    @Column(name = "userInfoId")
    private String userInfoId;

    public String getUserDailyHealthMonitorInfoId() {
        return userDailyHealthMonitorInfoId;
    }

    public void setUserDailyHealthMonitorInfoId(String userDailyHealthMonitorInfoId) {
        this.userDailyHealthMonitorInfoId = userDailyHealthMonitorInfoId;
    }

    public String getUserWeight() {
        return userWeight;
    }

    public void setUserWeight(String userWeight) {
        this.userWeight = userWeight;
    }

    public String getUserBloodPressureSystolic() {
        return userBloodPressureSystolic;
    }

    public void setUserBloodPressureSystolic(String userBloodPressureSystolic) {
        this.userBloodPressureSystolic = userBloodPressureSystolic;
    }

    public String getUserPulse() {
        return userPulse;
    }

    public void setUserPulse(String userPulse) {
        this.userPulse = userPulse;
    }

    public String getUserSpo2() {
        return userSpo2;
    }

    public void setUserSpo2(String userSpo2) {
        this.userSpo2 = userSpo2;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public String getUserInfoId() {
        return userInfoId;
    }

    public void setUserInfoId(String userInfoId) {
        this.userInfoId = userInfoId;
    }

    public String getUserBloodPressureDiastolic() {
        return userBloodPressureDiastolic;
    }

    public void setUserBloodPressureDiastolic(String userBloodPressureDiastolic) {
        this.userBloodPressureDiastolic = userBloodPressureDiastolic;
    }

    public String getUserTemperature() {
        return userTemperature;
    }

    public void setUserTemperature(String userTemperature) {
        this.userTemperature = userTemperature;
    }
}
