package com.guwr.jdk8.chap8;

@FunctionalInterface
interface ValidationStrategy {
    boolean execute(String s);
}

/**
 * Created by   guwr
 * Project_name jdk8
 * Path         com.guwr.jdk8.chap8.StrategyMain
 * Date         2017/7/27
 * Time         11:55
 * Description  策略模式
 */
public class StrategyMain {

    public static void main(String[] args) {
        // old school
        Validator v1 = new Validator(new IsNumeric());
        System.out.println(v1.validate("aaaa"));
        Validator v2 = new Validator(new IsAllLowerCase());
        System.out.println(v2.validate("bbbb"));

        // with lambdas
        Validator v3 = new Validator(s -> s.matches("\\d+"));
        System.out.println(v3.validate("aaaa"));
        Validator v4 = new Validator(s -> s.matches("[a-z]+"));
        System.out.println(v4.validate("bbbb"));
    }
}

class IsAllLowerCase implements ValidationStrategy {
    public boolean execute(String s) {
        return s.matches("[a-z]+");
    }
}

class IsNumeric implements ValidationStrategy {
    public boolean execute(String s) {
        return s.matches("\\d+");
    }
}

class Validator {
    ValidationStrategy strategy;

    public Validator(ValidationStrategy v) {
        this.strategy = v;
    }

    public boolean validate(String s) {
        return strategy.execute(s);
    }
}