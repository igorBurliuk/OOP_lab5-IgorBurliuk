package com.company;

import java.util.Scanner;

public class Employer {
    private String login;
    private String password;
    private String name;
    private String needWork;
    private int pay;
    private int workMark = 0;

    public Employer(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public void setWork(String needWork) {
        this.needWork = needWork;
    }
    public void setMoney(int pay) {
        this.pay = pay;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getLogin() {
        return login;
    }
    public String getPassword() {
        return password;
    }
    public String getName() {
        return name;
    }

    public void setNeedWork(String needWork, int pay) {
        this.needWork = needWork;
        this.pay = pay;
    }
    public String getNeedWork() {
        return needWork;
    }
    public int getPay() {
        return pay;
    }

    public int checkWorkMark() {
        return workMark;
    }
    public void changeWorkMark() {
        workMark = 1;
    }
}
