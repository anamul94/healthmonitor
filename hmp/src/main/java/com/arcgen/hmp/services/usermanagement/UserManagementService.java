package com.arcgen.hmp.services.usermanagement;

import com.arcgen.hmp.models.domains.usermanagement.UserInfo;
import com.arcgen.hmp.models.views.usemanagement.UserInfoVM;
import com.arcgen.hmp.models.views.usemanagement.UserLoginInfoVM;
import org.springframework.stereotype.Service;


@Service
public interface UserManagementService {
    UserInfo userInfoViewToDomain(UserInfoVM userInfoVM);
    
//    UserInfoVM userInfoDomainToView(UserInfo userInfo);
    //UserAuthenticationInfo userInfoViewToUserAuthenticationDomain(UserInfoVM userInfoVM);
   String saveUserInfo(UserInfoVM userInfoVM);

   UserLoginInfoVM userLogin(UserLoginInfoVM userLoginInfo);
   
   UserInfoVM getUserInfo(String userInfoId);
   
}
