package com.arcgen.hmp.util;


import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public interface UtilService {

    String generateUniqueId();

    String dateToString(LocalDateTime localDateTime);


    
}
