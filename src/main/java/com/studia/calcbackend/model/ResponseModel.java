package com.studia.calcbackend.model;

public class ResponseModel {

    public boolean success;
    public String errorMsg;
    public String result;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public boolean getSuccess() {
        return success;
    }

    public String getErrorMsg() {
        return this.errorMsg;
    }

}
