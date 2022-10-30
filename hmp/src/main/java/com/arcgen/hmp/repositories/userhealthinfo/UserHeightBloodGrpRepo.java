package com.arcgen.hmp.repositories.userhealthinfo;

import com.arcgen.hmp.models.domains.userhealthinfo.UserHeightBloodGrpInfo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserHeightBloodGrpRepo extends CrudRepository<UserHeightBloodGrpInfo, String>{
    UserHeightBloodGrpInfo findByUserInfoId(String userInfoId);
}
