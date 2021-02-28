package com.pht.contract.constant;

public class ContractDict {
    public static final String CONTRACT_STATUS_INVALID ="00";//合同无效
    public static final String CONTRACT_STATUS_VALID ="01";//合同有效

    public static final String PAY_TYPE_ONLINE ="00";//支付类型 线上支付
    public static final String CONTRACT_OFFLINE ="01";//支付类型线下支付

    public static final String PAY_METHOD_ZF ="zf";
    public static final String PAY_METHOD_VX="vx";
    public static final String PAY_METHOD_BANK="bank";
    public static final String PAY_METHOD_OTHER="other";

    public static final String OPERATE_CREATE="create";
    public static final String OPERATE_UPDATE="update";
    public static final String OPERATE_DELETE="delete";

}
