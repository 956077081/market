package com.pht.Common;

public class CommonResult<T> {

    private long code;//状态吗
    private String mess;//提示信息
    private T data;//数据

    public CommonResult(long code, String mess, T data) {
        this.code = code;
        this.mess = mess;
        this.data = data;
    }

    public static <T> CommonResult<T> success(String mess, T data){
        return new CommonResult<T>(ResultCode.SUCCESS.getCode(),mess,data);
    }
    public static <T> CommonResult<T> success( T data){
        return new CommonResult<T>(ResultCode.SUCCESS.getCode(),ResultCode.SUCCESS.getMessage(),data);
    }
    public static <T> CommonResult<T> failed(String mess, T data){
        return new CommonResult<T>(ResultCode.Fail.getCode(),mess,data);
    }
    public static <T> CommonResult<T> failed( T data){
        return new CommonResult<T>(ResultCode.Fail.getCode(),ResultCode.Fail.getMessage(),data);
    }
    public long getCode() {
        return code;
    }

    public void setCode(long code) {
        this.code = code;
    }

    public String getMess() {
        return mess;
    }

    public void setMess(String mess) {
        this.mess = mess;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
