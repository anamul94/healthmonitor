package com.arcgen.hmp.repositories.userhealthinfo;

import com.arcgen.hmp.models.domains.userhealthinfo.UserDailyHealthMonitorInfo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDailyHealthMonitorInfoRepo extends CrudRepository<UserDailyHealthMonitorInfo, String>{

    List<UserDailyHealthMonitorInfo> findByUserInfoId(String userInfoId);
}
