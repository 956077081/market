package com.pht.config.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.serializer.SimplePropertyPreFilter;
import com.google.common.collect.Maps;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.StringUtils;
import org.dom4j.Document;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class QmDataConvertUtils {

    /**
     * map转对象
     * */
    public static <T> T map2Obj(Map<String, Object> map, Class<?> clazz) throws Exception {
        if (map == null) {
            return null;
        }
        Object obj = clazz.newInstance();
//		Field[] fields = clazz.getDeclaredFields();
//		for (Field field : fields) {
//			int mod = field.getModifiers();
//			if (Modifier.isStatic(mod) || Modifier.isFinal(mod)) {
//				continue;
//			}
//			field.setAccessible(true);
//			field.set(obj, map.get(field.getName()));
//		}
        BeanUtils.populate(obj, map);
        return (T) obj;
    }

    /**
     * 对象转map
     * */
    public static Map<String, Object> obj2Map(Object obj) throws Exception {
        if (obj == null) {
            return null;
        }
        Map<String, Object> map = Maps.newHashMap();
        Field[] declaredFields = obj.getClass().getDeclaredFields();
        for (Field field : declaredFields) {
            field.setAccessible(true);
            map.put(field.getName(), field.get(obj));
        }
        return map;
//		return new BeanMap(obj);
    }

    /**
     * json字符串转json对象
     * */
    public static JSONObject jsonStr2JsonObj(String str) {
        return JSON.parseObject(str);
    }

    /**
     * json字符串转json对象
     * */
    public static JSONArray jsonStr2JsonArr(String str) {
        return JSON.parseArray(str);
    }

    /**
     * 对象转json
     * */
    public static JSON obj2Json(Object obj) {
        return JSON.parseObject(obj2JsonStr(obj));
    }

    /**
     * 对象转json字符串
     * */
    public static String obj2JsonStr(Object obj) {
        return JSON.toJSONString(obj);
    }

    /**
     * 对象转json字符串，并忽略某些属性
     * */
    public static String obj2JsonStrIgnoreFields(Object obj, String... fields) {
        SimplePropertyPreFilter ignoreFilter = new SimplePropertyPreFilter();
        ignoreFilter.getExcludes().addAll(Arrays.asList(fields));
        return JSON.toJSONString(obj, ignoreFilter);
    }

    /**
     * 对象转json字符串
     * */
    public static String obj2JsonStrWithFeature(Object obj, SerializerFeature... features) {
        return JSON.toJSONString(obj, features);
    }

    /**
     * json字符串转map
     * */
    public static Map<String, Object> jsonStr2Map(String str) {
        return jsonStr2Obj(str, Map.class);
    }

    /**
     * json转map
     * */
    public static Map<String, Object> json2Map(JSONObject obj) {
        return jsonStr2Obj(JSONObject.toJSONString(obj), Map.class);
    }

    /**
     * jsonArr转List<Map>
     * */
    public static List<Map<String, Object>> jsonArr2ListMap(JSONArray arr) {
        return JSONArray.parseObject(obj2JsonStr(arr), List.class);
    }

    /**
     * List转jsonArr
     * */
    public static <T> JSONArray list2JSONArr(List<T> list) {
        return JSONArray.parseArray(obj2JsonStr(list));
    }

    /**
     * jsonStr转obj
     * */
    public static <T> T jsonStr2Obj(String str, Class<?> clazz) {
        return (T) JSONObject.parseObject(StringUtils.isBlank(str) ? null : str, clazz);
    }

    /**
     * jsonStr转List<T>
     * */
    public static <T> List<T> jsonStr2ObjList(String str, Class<?> clazz) {
        return (List<T>) JSONObject.parseArray(str, clazz);
    }

    /**
     * xmlStr转对象
     * */
    public static <T> T xml2Obj(String xmlStr, Class<?> clazz) throws Exception {
        Document doc = QmXmlUtils.getDocFromStr(xmlStr);
        if (doc != null) {
            return QmXmlUtils.element2Bean(doc.getRootElement(), clazz);
        }
        return null;
    }

    /**
     * xmlStr转List<T>
     * */
    public static <T> List<T> xml2ObjList(String xmlStr, Class<?> clazz) {
        return null;
    }

    /**
     * xmlStr转JSONObject
     * */
    public static JSONObject xml2JSONObject(String xmlStr) throws Exception {
        if (StringUtils.isBlank(xmlStr)) {
            return null;
        }
        return QmXmlUtils.xml2Json(xmlStr);
    }

    /**
     * xmlStr转JSONArray
     * */
    public static JSONArray xml2JSONArr(String xmlStr) {
        return null;
    }

}
