package com.guwr.jdk8.chap4;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * Created by   guwr
 * Project_name jdk8
 * Path         com.guwr.jdk8.chap4.Chapter6
 * Date         2017/7/21
 * Time         13:21
 * Description
 */
public class Chapter4 {
    public static void main(String[] args) {
        Dish.menu.stream().filter(item -> {
            System.out.println("item.getName() = " + item.getName());
            return item.getCalories() < 400;
        }).map(item->item.getName()).limit(3).forEach(System.out::println);

        List<Integer> integers1 = Arrays.asList(1, 2, 3);
        List<Integer> integers2 = Arrays.asList(3, 4);

         integers1.stream().flatMap(item -> integers2.stream().map(i -> Arrays.asList(item, i))).forEach(System.out::println);

//        System.out.println("listStream = " + listStream);

        boolean anyMatch = Dish.menu.stream().anyMatch(Dish::isVegetarian);

        System.out.println("anyMatch = " + anyMatch);

    }
}

//            Arrays.asList(new Dish("pork", false, 800, Dish.Type.MEAT),
//                    new Dish("beef", false, 700, Dish.Type.MEAT),
//                    new Dish("chicken", false, 400, Dish.Type.MEAT),
//                    new Dish("french fries", true, 530, Dish.Type.OTHER),
//                    new Dish("rice", true, 350, Dish.Type.OTHER),
//                    new Dish("season fruit", true, 120, Dish.Type.OTHER),
//                    new Dish("pizza", true, 550, Dish.Type.OTHER),
//                    new Dish("prawns", false, 400, Dish.Type.FISH),
//                    new Dish("salmon", false, 450, Dish.Type.FISH));