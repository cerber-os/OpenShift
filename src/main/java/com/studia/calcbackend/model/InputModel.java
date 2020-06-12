package com.studia.calcbackend.model;

public class InputModel {

    public String first;
    public String second;
    public String operator;
    public String func;

    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String getSecond() {
        return second;
    }

    public void setSecond(String second) {
        this.second = second;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getFunc() {
        return func;
    }

    public void setFunc(String func) {
        this.func = func;
    }

    @Override
    public String toString() {
        return first + ";" + second + ";" + operator + ";" + func;
    }
}
