package com.zhanghp.returnJson;

/**
 * @author: zhanghp
 * @version: 1.0
 */
public class ReturnObject {
    private String message="";
    private Integer code =200;
    private Object result;

    public ReturnObject() {
    }

    public ReturnObject(String message, Object result) {
        this.message = message;
        this.result = result;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }

    public ReturnObject(Object result) {
        this.result = result;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "ReturnObject{" +
                "message='" + message + '\'' +
                ", code=" + code +
                ", result=" + result +
                '}';
    }
}
