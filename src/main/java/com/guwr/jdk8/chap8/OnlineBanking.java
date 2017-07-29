package com.guwr.jdk8.chap8;

/**
 * Created by   guwr
 * Project_name jdk8
 * Path         com.guwr.jdk8.chap8.OnlineBanking
 * Date         2017/7/27
 * Time         14:34
 * Description
 */
public abstract class OnlineBanking {
    public void processCustomer(int id) {
        Customer c = Database.getCustomerWithId(id);
        makeCustomerHappy(c);
    }

    abstract void makeCustomerHappy(Customer c);
}

class OnlineBankingImpl extends OnlineBanking {
    @Override
    void makeCustomerHappy(Customer c) {
          processCustomer(5);
    }
}

class Customer {

}

class Database {
    static Customer getCustomerWithId(int id) {
        return new Customer();
    }
}
