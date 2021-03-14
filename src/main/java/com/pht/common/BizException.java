package com.pht.common;

public class BizException  extends RuntimeException{
    private  String  message;
    private String errCode;

    public BizException(String message, String errCode) {
        this.message = message;
        this.errCode = errCode;
    }

    public BizException(String message) {
        this.message = message;
    }

    public  String getErrMesg(){
        return this.message;
    }

    public String getErrCode() {
        return errCode;
    }

    public void setErrCode(String errCode) {
        this.errCode = errCode;
    }
}
