package com.pht.config.utils.meta;

import com.pht.config.utils.QmDateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.util.Date;

public class FieldMetaUtils {
    private static Logger log = LoggerFactory.getLogger(FieldMetaUtils.class);
    /**
     * 根据字段类型来转换数据类型
     */
    @SuppressWarnings("unchecked")
    public static <T> T convertDataType(Field f, Object value ) {
        if (f.getType() == value.getClass()) {
            return (T)value;
        } else {
            if (f.getType() == String.class) {
                return (T) value.toString();
            } else if (f.getType() == Long.class) {
                return (T) new Long(value.toString());
            } else if (f.getType() == BigDecimal.class) {
                return (T) new BigDecimal(value.toString());
            } else if (f.getType() == Integer.class) {
                return (T) new Integer(value.toString());
            } else if (f.getType() == Date.class) {
                return (T) QmDateUtils.parse(value.toString());
            } else {
                return (T) value;
            }
        }
    }

    /**
     * 获取字段的泛型参数类型
     */
    public static ClassMetaInfo[] getGenericParamType( Field field ) {
        Type type = field.getGenericType();
        if( type != null && type instanceof ParameterizedType) {
            return getParamTypeMetaInfo( (ParameterizedType)type );
        }
        return null;
    }

    /**
     * 获取泛型参数类的元信息
     */
    private static ClassMetaInfo[] getParamTypeMetaInfo( ParameterizedType ptype ) {
        Type[] actualTypes = ptype.getActualTypeArguments();
        if( actualTypes != null && actualTypes.length > 0 ) {
            try {
                ClassMetaInfo[] metaInfos = new ClassMetaInfo[actualTypes.length];
                int k = 0;
                for( Type atype : actualTypes ) {
                    if( atype instanceof ParameterizedType ) {
                        ParameterizedType pt = (ParameterizedType)atype;
                        ClassMetaInfo classMeta = new ClassMetaInfo( Class.forName( pt.getRawType().getTypeName() ) );
                        classMeta.setParamClassMetas( getParamTypeMetaInfo(pt) );
                        metaInfos[k] = classMeta;
                    }else {
                        metaInfos[k] = new ClassMetaInfo( Class.forName( atype.getTypeName() ) );
                    }
                    k++;
                }
                return metaInfos;
            } catch (ClassNotFoundException e) {
                log.error("get class error: {}", e);
                throw new RuntimeException(e);
            }
        }
        return null;
    }

}
