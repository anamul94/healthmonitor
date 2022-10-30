package com.arcgen.hmp.services.userhealthinfo;

import com.arcgen.hmp.models.domains.userhealthinfo.UserDailyHealthMonitorInfo;
import com.arcgen.hmp.models.domains.userhealthinfo.UserHeightBloodGrpInfo;
import com.arcgen.hmp.models.views.userhealthinfo.UserDailyHealthMonitorInfoVM;
import com.arcgen.hmp.models.views.userhealthinfo.UserHeightBloodGrpVM;
import org.springframework.stereotype.Service;

@Service
public interface UserHealthInofServices {


    UserHeightBloodGrpInfo userHeightBloodGrpViewToDomain(UserDailyHealthMonitorInfoVM userDailyHealthMonitorInfoVM);
    UserHeightBloodGrpVM userHeightBloodGrpDomainToView(UserHeightBloodGrpInfo userHeightBloodGrpInfo);

    UserDailyHealthMonitorInfo userDailyHealthMonitorInfoViewToDomain(UserDailyHealthMonitorInfoVM userDailyHealthMonitorInfoVM);

    UserHeightBloodGrpVM getUserHeightBloodGro(String userInfoId);

   // UserHeightBloodGrpInfo saveUserHeightBloodGrp(UserHeightBloodGrpVM userHeightBloodGrpVM);
   UserDailyHealthMonitorInfoVM saveUserDailyHealthInfo(UserDailyHealthMonitorInfoVM userDailyHealthMonitorInfoVM);

}
