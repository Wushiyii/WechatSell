package com.miso.utils;

import java.util.Random;

/**
 * Created by Wushiyi on 2017-10-11.
 */
public  class KeyUtils {

    /**
     * 生成唯一主键
     * 格式：时间+随机数
     * @return
     */
    public static synchronized String getUniqueKey(){

        Random random = new Random();
        Integer num = random.nextInt(900000) + 100000;
        return System.currentTimeMillis() + String.valueOf(num);
    }
}
