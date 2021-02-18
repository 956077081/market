package com.pht.common;

public enum ResultCode {
    SUCCESS(200, "操作成功"),
    Fail(500, "操作失败"),
    VALIDATE_FAILED(404, "参数校验失败"),
    UAUTHORIZED(401, "暂未登陆或token过期"),
    FORBIDDEN(403, "没有相关权限");
    private long code;
    private String message;

    ResultCode(long code, String message) {
        this.code = code;
        this.message = message;
    }

    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    }
