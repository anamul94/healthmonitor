package com.arcgen.hmp.repositories.usermanagement;

import com.arcgen.hmp.models.domains.usermanagement.UserAuthenticationInfo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserAuthenticationInfoRepo extends CrudRepository<UserAuthenticationInfo, String>{
    
    UserAuthenticationInfo findByUserEmail(String userEmail);

    //UserAuthenticationInfo findByUserEmailAndUserPassword(String userEmail);
}
