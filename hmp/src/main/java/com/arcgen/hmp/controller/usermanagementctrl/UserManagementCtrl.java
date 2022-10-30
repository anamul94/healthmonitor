
package com.arcgen.hmp.controller.usermanagementctrl;

import com.arcgen.hmp.models.views.reward.UserRewardVM;
import com.arcgen.hmp.models.views.usemanagement.UserInfoVM;
import com.arcgen.hmp.models.views.usemanagement.UserLoginInfoVM;
import com.arcgen.hmp.models.views.userhealthinfo.UserDailyHealthMonitorInfoVM;
import com.arcgen.hmp.models.views.userhealthinfo.UserHeightBloodGrpVM;
import com.arcgen.hmp.services.usermanagement.UserManagementService;
import com.arcgen.hmp.services.reward.UserRewardService;
import com.arcgen.hmp.services.userhealthinfo.UserHealthInofServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin("*")
@RequestMapping("/api/v1/")
public class UserManagementCtrl {
    
    @Autowired
    UserManagementService userManagementService;

    @Autowired
    UserHealthInofServices userHealthInofServices;

    @Autowired
    UserRewardService userRewardService;

    @RequestMapping(method = RequestMethod.POST, value="/register-user")
    String registerUserInfo(@RequestBody UserInfoVM userInfoVM){
        String returStatus = userManagementService.saveUserInfo(userInfoVM);
        return  returStatus ;
     }

    @RequestMapping(method = RequestMethod.POST, value="/user-login")
    UserLoginInfoVM userLogin(@RequestBody UserLoginInfoVM userLoginInfo){
       
      return userManagementService.userLogin(userLoginInfo);
       
   }
   
    @RequestMapping(method = RequestMethod.POST, value="/get-user-info")
    UserInfoVM getUserInfo(@RequestBody String userInfoId){
       return userManagementService.getUserInfo(userInfoId);
   }

   @RequestMapping(method = RequestMethod.POST, value = "/get-user-height-bloodgrp")
   UserHeightBloodGrpVM getUserHeightBloodGrp(@RequestBody String userInfoId){
    return  userHealthInofServices.getUserHeightBloodGro(userInfoId);
   }

   @RequestMapping(method = RequestMethod.POST, value = "/save-daily-heealthinfo")
   UserDailyHealthMonitorInfoVM saveDailyHealthInfo(@RequestBody UserDailyHealthMonitorInfoVM userDailyHealthMonitorInfoVM){
      UserDailyHealthMonitorInfoVM savedUserHealthInfoVM = userHealthInofServices.saveUserDailyHealthInfo(userDailyHealthMonitorInfoVM);
        return  savedUserHealthInfoVM;
   }
   @RequestMapping(method = RequestMethod.POST, value = "/check-reward")
   UserRewardVM checkReward(@RequestBody String userInfoId){
       UserRewardVM rewardVM = new UserRewardVM();
        boolean reward = userRewardService.checkReward(userInfoId);
        if(reward){
            rewardVM.setRewardStatus("1");
        }
        else {
            rewardVM.setRewardStatus("0");
        }

        return  rewardVM;
   }
}
