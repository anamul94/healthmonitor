package com.arcgen.hmp.services.usermanagement;

import com.arcgen.hmp.models.domains.usermanagement.UserAuthenticationInfo;
import com.arcgen.hmp.models.domains.usermanagement.UserInfo;
import com.arcgen.hmp.models.views.usemanagement.UserInfoVM;
import com.arcgen.hmp.models.views.usemanagement.UserLoginInfoVM;
import com.arcgen.hmp.repositories.usermanagement.UserAuthenticationInfoRepo;
import com.arcgen.hmp.repositories.userhealthinfo.UserDailyHealthMonitorInfoRepo;
import com.arcgen.hmp.repositories.userhealthinfo.UserHeightBloodGrpRepo;
import com.arcgen.hmp.repositories.usermanagement.UserInfoRepo;
import com.arcgen.hmp.util.UtilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserManagementServiceImpl implements UserManagementService{

    @Autowired
    UserInfoRepo userInfoRepo;
    
    @Autowired
    UserHeightBloodGrpRepo userHealthMonitorInfoRepo;
    
      @Autowired 
     UserDailyHealthMonitorInfoRepo userDailyHealthMonitorInfoRepo;
        
      @Autowired 
      UserAuthenticationInfoRepo userAuthenticationInfoRepo;
      
      @Autowired
      UtilService utilService;
    
    @Override
    public UserInfo userInfoViewToDomain(UserInfoVM userInfoVM) {
       UserInfo userInfo = new UserInfo();
       
        String authenticationId = prepareUserAuthenticationId(userInfoVM.getUserEmail(), userInfoVM.getUserPassword());

        String userInfoId = utilService.generateUniqueId();
        userInfo.setUserInfoId(userInfoId);
        userInfo.setUserEmail(userInfoVM.getUserEmail());
        userInfo.setUserName(userInfoVM.getUserName());
        userInfo.setUserPhone(userInfoVM.getUserPhone());
        userInfo.setUserDob(userInfoVM.getUserDob());
        userInfo.setUserAddress(userInfoVM.getUserAddress());
        userInfo.setUserAuthenticationInfoId(authenticationId);

        return userInfo;
    }


    @Override
    public String saveUserInfo(UserInfoVM userInfoVM) {
        String flag = "0";
        UserAuthenticationInfo savedAuthInfo = userAuthenticationInfoRepo.findByUserEmail(userInfoVM.getUserEmail());
        if (savedAuthInfo != null){
            flag = "1";
        }
        else {
            UserInfo userInfo =userInfoViewToDomain(userInfoVM);
            userInfoRepo.save(userInfo);
        }

        return flag;
    }

    private String prepareUserAuthenticationId(String userEmail, String userPassword) {
        UserAuthenticationInfo userAuthenticationInfo = new UserAuthenticationInfo();

            String userAuthId = utilService.generateUniqueId();
        
            userAuthenticationInfo.setUserAuthenticationInfoId(userAuthId);
            userAuthenticationInfo.setUserEmail(userEmail);
            userAuthenticationInfo.setUserPassword(userPassword);

            userAuthenticationInfoRepo.save(userAuthenticationInfo);
        
        return userAuthId;
        
                
    }

    @Override
    public UserLoginInfoVM userLogin(UserLoginInfoVM userLoginInfo) {
        
        String userInfoId = "";
        UserAuthenticationInfo userAuthInfo = userAuthenticationInfoRepo.findByUserEmail(userLoginInfo.getUserEmail());
        if(userLoginInfo != null){
            if(userAuthInfo.getUserPassword().equals(userLoginInfo.getUserPassword())){
                userInfoId = userInfoRepo.findByUserAuthenticationInfoId(userAuthInfo.getUserAuthenticationInfoId()).getUserInfoId();
                String userName = userInfoRepo.findByUserInfoId(userInfoId).getUserName();
                userLoginInfo.setUserName(userName);
                userLoginInfo.setUsreInfoId(userInfoId);
            }

        }
        return userLoginInfo;
    }

    @Override
    public UserInfoVM getUserInfo(String userInfoId) {
        
        UserInfoVM userInfoVM = new UserInfoVM();
        
        UserInfo savedUserInfo = userInfoRepo.findByUserInfoId(userInfoId);
        
        if(savedUserInfo!=null){
            //userInfoVM = userInfoDomainToView(savedUserInfo);
        }
        return userInfoVM;

    }
    
}
