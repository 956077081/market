package com.pht.common.utils.meta;

import java.util.List;
import java.util.Map;

public class ClassMetaInfo {
    //java类
    public Class<?> clazz;

    //泛型参数类的元信息
    public ClassMetaInfo[] paramClassMetas;

    public ClassMetaInfo( Class<?> clazz ) {
        this.clazz = clazz;
    }

    public ClassMetaInfo setParamClassMetas( ClassMetaInfo...paramClassMetas) {
        this.paramClassMetas = paramClassMetas;
        return this;
    }

    public boolean isRawType() {
        return paramClassMetas == null || paramClassMetas.length == 0;
    }

    public boolean isCollectionType() {
        return List.class.isAssignableFrom( clazz ) || Map.class.isAssignableFrom( clazz );
    }
}
