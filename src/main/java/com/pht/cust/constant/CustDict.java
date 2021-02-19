package com.pht.cust.constant;

import com.pht.common.BizDictAnot;
import com.sun.org.glassfish.gmbal.Description;

public class CustDict {
    @BizDictAnot(dictTypeId ="CustType" ,dictName = "自然人")
    public static String  CUSTTYPE_00 ="00";
    @BizDictAnot(dictTypeId ="CustType" ,dictName = "公司")
    public static String  CUSTTYPE_01 ="01";

    @BizDictAnot(dictTypeId ="CustStatus" ,dictName = "客户有效")
    public static String  CUSTSTATUS_01 ="01";
    @BizDictAnot(dictTypeId ="CustStatus" ,dictName = "客户无效")
    public static String  CUSTSTATUS_00 ="00";
}
