package com.arcgen.hmp.util;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class UtilServiceImpl implements UtilService {

    @Override
    public String generateUniqueId() {
        return java.util.UUID.randomUUID().toString();
    }

    @Override
    public String dateToString(LocalDateTime localDateTime) {
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String formattedDate = localDateTime.format(myFormatObj);
        return  formattedDate;
    }


}
