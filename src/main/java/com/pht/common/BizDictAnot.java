package com.pht.common;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public  @interface BizDictAnot {
    abstract String dictTypeId();
    abstract String dictName();
    abstract String parentDictTypeId() default "";
    abstract String parentDictId() default "";
    abstract String dsc() default "";
}
