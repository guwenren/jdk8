package com.guwr.jdk8.chap5;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;

/**
 * Created by guwr
 * Project_name jdk8
 * Path com.guwr.jdk8.chap5.Chapter5
 * Date 17/7/23
 * Time 下午4:30
 * Description
 */
public class Chapter5 {
    public static void main(String[] args) {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario","Milan");
        Trader alan = new Trader("Alan","Cambridge");
        Trader brian = new Trader("Brian","Cambridge");
        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );

        transactions.stream().filter(o-> Objects.equals(o.getYear(),2011))
                .sorted(Comparator.comparingInt(Transaction::getValue))
                .forEach(System.out::println);

        transactions.stream().map(o->o.getTrader().getCity()).distinct().forEach(System.out::println);


//        List<Trader> traders =
                transactions.stream()
                        .map(Transaction::getTrader)
                        .filter(trader -> trader.getCity().equals("Cambridge"))
                        .distinct()
                        .sorted(comparing(Trader::getName))
                        .collect(toList()).forEach(System.out::println);
//        System.out.println(traders);

        transactions.stream().map(o->o.getTrader().getName()).distinct().sorted().forEach(System.out::println);


        boolean milan = transactions.stream().anyMatch(o -> o.getTrader().getCity().equals("Milan"));

        System.out.println("milan = " + milan);

        Integer cambridge = transactions.stream().filter(o -> o.getTrader().getCity().equals("Cambridge"))
                .map(o -> o.getValue()).reduce(0, (o1, o2) -> o1 + o2);

        System.out.println("cambridge = " + cambridge);

        Integer max = transactions.stream().map(o -> o.getValue()).reduce(0, Integer::max);

        System.out.println("max = " + max);

         transactions.stream().map(o -> o.getValue()).reduce(Integer::min).ifPresent(o1-> System.out.println(o1));

    }
}
