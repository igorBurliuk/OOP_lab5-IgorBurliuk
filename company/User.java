package com.company;

public class User {
    private String login = "";
    private String password = "";
    private String name = "";
    private String work = "";
    private int money = 0;
    private int workMark = 0;

    public User(String login, String password) {
        this.login = login;
        this.password = password;
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

    public void setWork(String work) {
        this.work = work;
    }
    public void setMoney(int money) {
        this.money = money;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getWork() {
        return work;
    }
    public int getMoney() {
        return money;
    }
    public int checkWorkMark() {
        return workMark;
    }
    public void changeWorkMark() {
        workMark = 1;
    }


}
