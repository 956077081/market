package com.pht.cust.constant;

import com.pht.common.BizDictAnot;
import com.sun.org.glassfish.gmbal.Description;

public class CustDict {
    @BizDictAnot(dictTypeId ="CustType" ,dictName = "自然人")
    public static String  CUSTTYPE_00 ="00";
    @BizDictAnot(dictTypeId ="CustType" ,dictName = "公司")
    public static String  CUSTTYPE_01 ="01";
}
