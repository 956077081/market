package com.pht.config.utils;

import com.alibaba.fastjson.JSONObject;
import com.pht.common.frame.LoggerFormator;
import com.pht.config.utils.meta.FieldMetaUtils;
import org.apache.commons.lang3.StringUtils;
import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.LinkedList;
import java.util.List;

public class QmXmlUtils {
    private static LoggerFormator log = LoggerFormator.getLogger(QmXmlUtils.class);

    //从字符串中生成document对象
    public static Document getDocFromStr(String xmlStr ) throws Exception {
        Document doc = null;
        try {
            doc = DocumentHelper.parseText( xmlStr );
        } catch (Exception e) {
            log.error("get doc from xml str error...", e);
            throw e;
        }
        return doc;
    }

    //从文件路径中生成document对象
    public static Document getDocFromFile( String filepath ){
        return getDocFromFile( new File( filepath ) );
    }

    //从文件中生成doc对象
    public static Document getDocFromFile( File file ) {
        SAXReader reader = new SAXReader();
        try {
            return reader.read( file );
        } catch (Exception e) {
            log.error("get doc from xml file error...", e);
        }
        return null;
    }

    //xml元素转换对象
    public static <T> T element2Bean( Element ele, Class<?> clazz) throws Exception {
        // 根据传入的Class动态生成pojo对象
        Object obj = clazz.newInstance();
        List<Element> list = ele.elements();
        for (Element element : list) {
            setElementText2Obj(element, obj);
        }
        return (T)obj;
    }

    //通过反射将xml元素的value设置到对象的属性上
    public static void setElementText2Obj( Element el, Object obj ) {
        try {
            Field field = obj.getClass().getField( el.getName() );
            if( field != null ){
                field.setAccessible( true );
                field.set(obj, FieldMetaUtils.convertDataType(field, el.getTextTrim()));
            }
        } catch (Exception e) {
            log.error("set attr from el to obj error...", e);
        }
    }

    //通过反射将xml元素的属性值设置到对象的属性上
    public static void setElementAttr2Obj( Element el, Object obj){
        List<Attribute> attrs = el.attributes();
        for( Attribute attr : attrs ){
            try {
                Field field = obj.getClass().getField( attr.getName() );
                if( field != null ){
                    field.setAccessible( true );
                    field.set(obj, FieldMetaUtils.convertDataType(field, attr.getStringValue()));
                }
            } catch (Exception e) {
                log.error("set attr from el to obj error...", e);
            }
        }
    }

    // 导出xml字符串到指定目录文件
    public static void exportXml(String xmlStr, String filePath) {
        XMLWriter writer = null;
        try {
            OutputFormat format = OutputFormat.createPrettyPrint();
            writer = new XMLWriter(new FileOutputStream(filePath), format);
            writer.write(getDocFromStr(xmlStr));
        } catch (Exception e) {
            log.error("export xml error...", e);
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    log.error("export xml关闭资源异常|", e);
                }
            }
        }
    }

    public static JSONObject xml2Json(String xmlStr) throws Exception {
        if (StringUtils.isBlank(xmlStr)) {
            return null;
        }
        JSONObject json = new JSONObject();
        Document doc = getDocFromStr(xmlStr);
        Element root = doc.getRootElement();
        json.put(root.getName(), iterateElement(root));
        return json;
    }

    @SuppressWarnings("rawtypes")
    private static JSONObject iterateElement(Element element) {
        List<Element> node = element.elements();
        JSONObject obj = new JSONObject();
        List list = null;
        for (Element child : node) {
            list = new LinkedList();
            String text = child.getTextTrim();
            if (StringUtils.isBlank(text)) {
                if (child.elements().size() == 0) {
                    obj.put(child.getName(), "");
                    continue;
                }
                if (obj.containsKey(child.getName())) {
                    list = (List) obj.get(child.getName());
                }
                list.add(iterateElement(child)); //遍历child的子节点
                obj.put(child.getName(), list);
            } else {
                if (obj.containsKey(child.getName())) {
                    Object value = obj.get(child.getName());
                    try {
                        list = (List) value;
                    } catch (ClassCastException e) {
                        list.add(value);
                    }
                }
                if (child.elements().size() == 0) { //child无子节点时直接设置text
                    obj.put(child.getName(), text);
                } else {
                    list.add(text);
                    obj.put(child.getName(), list);
                }
            }
        }
        return obj;
    }
}
