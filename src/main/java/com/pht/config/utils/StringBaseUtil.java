package com.pht.config.utils;

import org.apache.commons.collections.MapUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class StringBaseUtil {

    public static String handleDollarNamedParamByRegex(String templateStr, Map<String, Object> paraMap) {
        if (paraMap == null) {
            paraMap = Collections.emptyMap();
        }
        String retStr = templateStr;
        // 将${ key }替换为 ${key}
        retStr = retStr.replaceAll("(\\$\\{\\s+)", "\\$\\{").replaceAll("(\\$t\\{\\s+)", "\\$t\\{").replaceAll("(\\s+\\})", "\\}");
        // 取消换行及结尾;
        retStr = retStr.replaceAll("\\s+", " ").trim().replace(";", "");
        // 获取需要替换的参数
        List<String> tParamSet = getReplaceParams(retStr, "$t");
        List<String> paramSet = getReplaceParams(retStr, "$");
        // 没有需要替换的参数直接返回模板sql
        if (paramSet.isEmpty() && tParamSet.isEmpty()) {
            return retStr;
        }

        // 替换模板中的参数
        for (String key : tParamSet) {
            String mapKey = key.replaceAll("(\\$t\\{|\\})", "");
            String val = MapUtils.getString(paraMap, mapKey);
            if (!paraMap.containsKey(mapKey) || "".equals(paraMap.get(mapKey))) {
                continue;
            }
            retStr = retStr.replaceAll("\\$t\\{" + mapKey + "\\}", val);
        }

        for (String key : paramSet) {
            String mapKey = key.replaceAll("(\\$\\{|\\})", "");
            String val = MapUtils.getString(paraMap, mapKey);
            String regex = "(\\$\\{" + mapKey + "\\})";
            retStr = retStr.replaceAll(regex, "" + val + "");
        }

        return retStr;
    }
    /**
     * 获取需要替换的参数
     * @param retStr
     * @return
     */
    public static List<String> getReplaceParams(String retStr, String prefix) {
        // 获取需要替换的参数
        List<String> paramSet = new ArrayList<>();
        int begIndex = -1;
        int endIndex = -1;
        while (true) {
            begIndex = retStr.indexOf(prefix + "{", ++begIndex);
            endIndex = retStr.indexOf('}', begIndex);
            if (begIndex < 0 || endIndex < 0) {
                break;
            }
            paramSet.add(retStr.substring(begIndex, endIndex + 1));
        }
        return paramSet;
    }
}
