package com.arcgen.hmp.services.reward;

import com.arcgen.hmp.models.domains.userhealthinfo.UserDailyHealthMonitorInfo;
import com.arcgen.hmp.repositories.userhealthinfo.UserDailyHealthMonitorInfoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserRewardServiceImpl implements UserRewardService {

    @Autowired
    UserDailyHealthMonitorInfoRepo userDailyHealthMonitorInfoRepo;


    @Override
    public boolean checkReward(String userInfoId) {
        boolean Loginreward = false;
        int rewardTimes = 0;
        List<UserDailyHealthMonitorInfo> userDailyHealthMonitorInfo = userDailyHealthMonitorInfoRepo.findByUserInfoId(userInfoId);

        if(userDailyHealthMonitorInfo != null && !userDailyHealthMonitorInfo.isEmpty()){

            for(UserDailyHealthMonitorInfo temp:userDailyHealthMonitorInfo){
                if(!temp.getDateTime().isEmpty() && checkBP(temp.getUserBloodPressureSystolic(), temp.getUserBloodPressureDiastolic()) && checkPulse(temp.getUserTemperature()) && checkTemp(temp.getUserTemperature()) && checkspo2(temp.getUserSpo2()) ){
                    rewardTimes++;
                }
            }

     }
        return rewardTimes>10?true:false;
    }

    private boolean checkBP(String systBP, String dystBP){
        boolean result = false;
        float systBPfloat=Float.parseFloat(systBP);
        float dystBPFloat=Float.parseFloat(dystBP);

        if ((systBPfloat>= 120.00 && systBPfloat<=129.00) && (dystBPFloat>=80.00 && dystBPFloat<=89.00) ){

            result = true;
        }
        return result;
    }

    private boolean checkPulse(String pulse){
        boolean result = false;
        float pulseFloat=Float.parseFloat(pulse);

        if (pulseFloat >=60.00 && pulseFloat <= 120.00 ){

            result = true;
        }
        return result;
    }

    private boolean checkspo2(String spo2){
        boolean result = false;
        float spo2Float=Float.parseFloat(spo2);

        if (spo2Float >=95.00 && spo2Float <= 100.00 ){

            result = true;
        }
        return result;
    }

    private boolean checkTemp(String temperatuer){
        boolean result = false;
        float temperatuerFloat=Float.parseFloat(temperatuer);

        if (temperatuerFloat >=97.00 && temperatuerFloat <= 99.00 ){

            result = true;
        }
        return result;
    }
}
