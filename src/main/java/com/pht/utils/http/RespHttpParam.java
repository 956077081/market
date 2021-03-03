package com.pht.utils.http;

public class RespHttpParam {
    private boolean isSuccess = true;
    private String res;

    public boolean isSuccess() {
        return isSuccess;
    }

    public void setSuccess(boolean success) {

        isSuccess = success;
    }
    public void setError(boolean success) {
        isSuccess = success;
    }
    public String getRes() {
        return res;
    }

    public void setRes(String res) {
        this.res = res;
    }

    @Override
    public String toString() {
        return "RespHttpParam{" +
                "isSuccess=" + isSuccess +
                ", res='" + res + '\'' +
                '}';
    }
}
