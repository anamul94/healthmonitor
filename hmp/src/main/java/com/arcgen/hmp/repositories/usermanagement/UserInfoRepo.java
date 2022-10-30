package com.arcgen.hmp.repositories.usermanagement;

import com.arcgen.hmp.models.domains.usermanagement.UserInfo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserInfoRepo extends CrudRepository<UserInfo, String>{
    
    UserInfo findByUserInfoId(String userInfoId);
   UserInfo  findByUserAuthenticationInfoId(String userAuthenticationInfoId);
//    @Query(value="SELECT user_info_id FROM user_info WHERE user_authentication_info_id = ?1", nativeQuery = true)
//    String findUserInfoId(String userAuthId);

    
}
