package com.day1.util;

import java.util.UUID;

public class UUIDUtil {

    public static String getUUID(){
        return UUID.randomUUID().toString().replace("-", "");
    }

}
