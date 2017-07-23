package com.guwr.jdk8.chap5;

/**
 * Created by guwr
 * Project_name jdk8
 * Path com.guwr.jdk8.chap5.Transaction
 * Date 17/7/23
 * Time 下午4:29
 * Description
 */
public class Transaction {

    private Trader trader;
    private int year;
    private int value;

    public Transaction(Trader trader, int year, int value)
    {
        this.trader = trader;
        this.year = year;
        this.value = value;
    }

    public Trader getTrader(){
        return this.trader;
    }

    public int getYear(){
        return this.year;
    }

    public int getValue(){
        return this.value;
    }

    public String toString(){
        return "{" + this.trader + ", " +
                "year: "+this.year+", " +
                "value:" + this.value +"}";
    }
}
