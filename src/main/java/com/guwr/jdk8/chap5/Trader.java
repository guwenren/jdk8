package com.guwr.jdk8.chap5;

/**
 * Created by guwr
 * Project_name jdk8
 * Path com.guwr.jdk8.chap5.Trader
 * Date 17/7/23
 * Time 下午4:28
 * Description
 */
public class Trader {
    private String name;
    private String city;

    public Trader(String n, String c){
        this.name = n;
        this.city = c;
    }

    public String getName(){
        return this.name;
    }

    public String getCity(){
        return this.city;
    }

    public void setCity(String newCity){
        this.city = newCity;
    }

    public String toString(){
        return "Trader:"+this.name + " in " + this.city;
    }
}
