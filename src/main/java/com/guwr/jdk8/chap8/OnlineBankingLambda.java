package com.guwr.jdk8.chap8;

import java.util.function.Consumer;

/**
 * Created by   guwr
 * Project_name jdk8
 * Path         com.guwr.jdk8.chap8.OnlineBankingLambda
 * Date         2017/7/27
 * Time         14:39
 * Description
 */
public class OnlineBankingLambda {
    public static void main(String[] args) {
        new OnlineBankingLambda().processCustomer(1337, (Customer1 c) -> System.out.println("Hello!"));
    }

    public void processCustomer(int id, Consumer<Customer1> makeCustomerHappy) {
        Customer1 c = Database1.getCustomerWithId(id);
        makeCustomerHappy.accept(c);
    }
}


class Customer1 {

}

class Database1 {
    static Customer1 getCustomerWithId(int id) {
        return new Customer1();
    }
}
