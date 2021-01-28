package com.example.gsce;

public class chose {

    private String name;
    private String number;
    private int progresstatus;

    public chose(String name, String number,int progresstatus) {
        this.name = name;
        this.number = number;
        this.progresstatus = Integer.parseInt (number);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

}
