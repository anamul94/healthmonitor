
package com.arcgen.hmp.models.domains.userhealthinfo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author raju
 */
@Entity
@Table(name = "UserHeightBloodGrpInfo")
public class UserHeightBloodGrpInfo {
    @Id
    @Column(name = "userHeightBloodGrpInfoId")
    private String userHeightBloodGrpInfoId;
    
    @Column(name = "userHeight")
    private String userHeight;
    
     @Column(name = "userBloodGroup")
    private String userBloodGroup;

      @Column(name="userInfoId")
    private String userInfoId;

    public String getUserHeightBloodGrpInfoId() {
        return userHeightBloodGrpInfoId;
    }

    public void setUserHeightBloodGrpInfoId(String userHeightBloodGrpInfoId) {
        this.userHeightBloodGrpInfoId = userHeightBloodGrpInfoId;
    }

    public String getUserHeight() {
        return userHeight;
    }

    public void setUserHeight(String userHeight) {
        this.userHeight = userHeight;
    }

    public String getUserBloodGroup() {
        return userBloodGroup;
    }

    public void setUserBloodGroup(String userBloodGroup) {
        this.userBloodGroup = userBloodGroup;
    }


    public String getUserInfoId() {
        return userInfoId;
    }

    public void setUserInfoId(String userInfoId) {
        this.userInfoId = userInfoId;
    }


}
