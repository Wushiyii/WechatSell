package com.miso.utils;

import com.miso.enums.CodeEnum;

/**
 * Created by Wushiyi on 2017-10-22.
 */
public class EnumUtil {

    public static <T extends CodeEnum> T getByCode(Integer code, Class<T> enumClass){
        for (T each : enumClass.getEnumConstants()){
            if(code.equals(each.getCode())){
                return each;
            }
        }
        return null;
    }
}
