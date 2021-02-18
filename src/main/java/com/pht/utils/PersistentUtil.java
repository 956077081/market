package com.pht.utils;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;

import java.util.Date;

public class PersistentUtil {
    public static String getBizEntity(Class classname) {
        String tablename = classname.getSimpleName().substring(0, 1);
        String sysdate = DateFormatUtils.format(new Date(), "yyMMddHHmmsss");
        return String.format("%s_%s_%s", tablename, sysdate, getRandomStr(6));
    }

    /**
     * 获取随机字符长度
     *
     * @param num
     * @return
     */
    private static String getRandomStr(int num) {
        return RandomStringUtils.randomAlphanumeric(num);
    }
}
