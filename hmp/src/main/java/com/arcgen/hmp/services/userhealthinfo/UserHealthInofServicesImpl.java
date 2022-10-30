package com.arcgen.hmp.services.userhealthinfo;

import com.arcgen.hmp.models.domains.userhealthinfo.UserDailyHealthMonitorInfo;
import com.arcgen.hmp.models.domains.userhealthinfo.UserHeightBloodGrpInfo;
import com.arcgen.hmp.models.views.userhealthinfo.UserDailyHealthMonitorInfoVM;
import com.arcgen.hmp.models.views.userhealthinfo.UserHeightBloodGrpVM;
import com.arcgen.hmp.repositories.userhealthinfo.UserDailyHealthMonitorInfoRepo;
import com.arcgen.hmp.repositories.userhealthinfo.UserHeightBloodGrpRepo;
import com.arcgen.hmp.repositories.usermanagement.UserInfoRepo;
import com.arcgen.hmp.util.UtilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class UserHealthInofServicesImpl implements UserHealthInofServices{

    @Autowired
    UserHeightBloodGrpRepo userHeightBloodGrpRepo;

    @Autowired
    UserDailyHealthMonitorInfoRepo userDailyHealthMonitorInfoRepo;

    @Autowired
    UserInfoRepo userInfoRepo;

    @Autowired
    UtilService utilService;

    @Override
    public UserHeightBloodGrpInfo userHeightBloodGrpViewToDomain(UserDailyHealthMonitorInfoVM userDailyHealthMonitorInfoVM) {
        UserHeightBloodGrpInfo userHeightBloodGrpInfo = new UserHeightBloodGrpInfo();
        String id = utilService.generateUniqueId();
        userHeightBloodGrpInfo.setUserHeightBloodGrpInfoId(id);
        userHeightBloodGrpInfo.setUserHeight(userDailyHealthMonitorInfoVM.getUserHeight());
        userHeightBloodGrpInfo.setUserBloodGroup(userDailyHealthMonitorInfoVM.getUserBloodGroup());
        userHeightBloodGrpInfo.setUserInfoId(userDailyHealthMonitorInfoVM.getUserInfoId());

        return userHeightBloodGrpInfo;
    }

    @Override
    public UserHeightBloodGrpVM userHeightBloodGrpDomainToView(UserHeightBloodGrpInfo userHeightBloodGrpInfo) {
        UserHeightBloodGrpVM heightBloodGrpVM = new UserHeightBloodGrpVM();
       String userName = userInfoRepo.findByUserInfoId(userHeightBloodGrpInfo.getUserInfoId()).getUserName();
        heightBloodGrpVM.setUserName(userName);
        heightBloodGrpVM.setUserBloodGroup(userHeightBloodGrpInfo.getUserBloodGroup());
        heightBloodGrpVM.setUserHeight(userHeightBloodGrpInfo.getUserHeight());
        heightBloodGrpVM.setUserInfoId(userHeightBloodGrpInfo.getUserInfoId());

        return heightBloodGrpVM;
    }

    @Override
    public UserDailyHealthMonitorInfo userDailyHealthMonitorInfoViewToDomain(UserDailyHealthMonitorInfoVM userDailyHealthMonitorInfoVM) {

        UserDailyHealthMonitorInfo userDailyHealthMonitorInfo = new UserDailyHealthMonitorInfo();

        String id = utilService.generateUniqueId();
        LocalDateTime currentDateObj = LocalDateTime.now();
        String currentDate = utilService.dateToString(currentDateObj);

        userDailyHealthMonitorInfo.setUserDailyHealthMonitorInfoId(id);
        userDailyHealthMonitorInfo.setUserWeight(userDailyHealthMonitorInfoVM.getUserWeight());
        userDailyHealthMonitorInfo.setUserBloodPressureSystolic(userDailyHealthMonitorInfoVM.getUserBloodPressureSystolic());
        userDailyHealthMonitorInfo.setUserBloodPressureDiastolic(userDailyHealthMonitorInfoVM.getUserBloodPressureDiastolic());
        userDailyHealthMonitorInfo.setUserPulse(userDailyHealthMonitorInfoVM.getUserPulse());
        userDailyHealthMonitorInfo.setUserSpo2(userDailyHealthMonitorInfoVM.getUserSpo2());
        userDailyHealthMonitorInfo.setUserTemperature(userDailyHealthMonitorInfoVM.getUserTemperature());
        userDailyHealthMonitorInfo.setDateTime(currentDate);
        userDailyHealthMonitorInfo.setUserInfoId(userDailyHealthMonitorInfoVM.getUserInfoId());

        return userDailyHealthMonitorInfo;
    }

    @Override
    public UserHeightBloodGrpVM getUserHeightBloodGro(String userInfoId) {
        UserHeightBloodGrpInfo userHeightBloodGrpInfo = userHeightBloodGrpRepo.findByUserInfoId(userInfoId);
        UserHeightBloodGrpVM userHeightBloodGrpVM = new UserHeightBloodGrpVM();
        if(userHeightBloodGrpInfo != null){
            userHeightBloodGrpVM = userHeightBloodGrpDomainToView(userHeightBloodGrpInfo);
        }

        return userHeightBloodGrpVM;
    }

    @Override
    public UserDailyHealthMonitorInfoVM saveUserDailyHealthInfo(UserDailyHealthMonitorInfoVM userDailyHealthMonitorInfoVM) {



        UserDailyHealthMonitorInfo userDailyHealthMonitorInfo= userDailyHealthMonitorInfoViewToDomain(userDailyHealthMonitorInfoVM);

        UserHeightBloodGrpInfo saveUserHeightBloodGrpInfo = userHeightBloodGrpRepo.findByUserInfoId(userDailyHealthMonitorInfoVM.getUserInfoId());
        if(saveUserHeightBloodGrpInfo == null){
            UserHeightBloodGrpInfo userHeightBloodGrpInfo = userHeightBloodGrpViewToDomain(userDailyHealthMonitorInfoVM);

            userHeightBloodGrpRepo.save(userHeightBloodGrpInfo);

            userDailyHealthMonitorInfoRepo.save(userDailyHealthMonitorInfo);
        }
        else {
            userDailyHealthMonitorInfoRepo.save(userDailyHealthMonitorInfo);
        }
        userDailyHealthMonitorInfoVM.setDateTime(userDailyHealthMonitorInfo.getDateTime());
        return  userDailyHealthMonitorInfoVM;
    }
}
