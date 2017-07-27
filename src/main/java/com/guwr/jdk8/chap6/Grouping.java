package com.guwr.jdk8.chap6;

import java.util.*;

import static java.util.stream.Collectors.*;

/**
 * Created by   guwr
 * Project_name jdk8
 * Path         com.guwr.jdk8.chap6.Grouping
 * Date         2017/7/25
 * Time         12:00
 * Description
 */
public class Grouping {


    public static void main(String[] args) {
        Map<Dish.Type, List<Dish>> collect = Dish.menu.stream().collect(groupingBy(Dish::getType));
        System.out.println("collect = " + collect);

        Map<CaloricLevel, List<Dish>> collect1 = Dish.menu.stream().collect(groupingBy(item -> {
            if (item.getCalories() <= 400) {
                return CaloricLevel.DIET;
            }
            return CaloricLevel.FAT;
        }));
        System.out.println("collect1 = " + collect1);


        Map<Dish.Type, Map<CaloricLevel, List<Dish>>> collect2 = Dish.menu.stream().collect(groupingBy(Dish::getType, groupingBy(item -> {
            if (item.getCalories() <= 400) return CaloricLevel.DIET;
            else if (item.getCalories() <= 700) return CaloricLevel.NORMAL;
            else return CaloricLevel.FAT;
        })));

        System.out.println("collect2 = " + collect2);

        Map<Dish.Type, Long> collect3 = Dish.menu.stream().collect(groupingBy(Dish::getType, counting()));

        System.out.println("collect3 = " + collect3);


        Map<Dish.Type, Optional<Dish>> collect4 = Dish.menu.stream().collect(groupingBy(Dish::getType,
                maxBy(Comparator.comparingInt(Dish::getCalories))));
        System.out.println("collect4 = " + collect4);


        Map<Dish.Type, Dish> collect5 = Dish.menu.stream().collect(groupingBy(Dish::getType, collectingAndThen(maxBy(Comparator.comparingInt(Dish::getCalories)), Optional::get)));
        System.out.println("collect5 = " + collect5);

        Optional<Dish> max = Dish.menu.stream().min(Comparator.comparingInt(Dish::getCalories));

        Dish dish = max.get();

        System.out.println("dish = " + dish);

        Map<Dish.Type, Set<CaloricLevel>> collect6 = Dish.menu.stream().collect(groupingBy(Dish::getType, mapping(item -> {
            if (item.getCalories() <= 400) return CaloricLevel.DIET;
            else if (item.getCalories() <= 700) return CaloricLevel.NORMAL;
            else return CaloricLevel.FAT;
        }, toSet())));


        System.out.println("collect6 = " + collect6);


        Map<Boolean, List<Dish>> collect7 = Dish.menu.stream().collect(partitioningBy(Dish::isVegetarian));

        System.out.println("collect7 = " + collect7);

        Map<Boolean, Map<Dish.Type, List<Dish>>> collect8 = Dish.menu.stream().collect(partitioningBy(Dish::isVegetarian, groupingBy(Dish::getType)));

        System.out.println("collect8 = " + collect8);


        Map<Boolean, Dish> collect9 = Dish.menu.stream().collect(partitioningBy(Dish::isVegetarian, collectingAndThen(maxBy(Comparator.comparingInt(Dish::getCalories)), Optional::get)));

        System.out.println("collect9 = " + collect9);
    }

    private static Map<Dish.Type, List<Dish>> groupDishesByType() {
        return null;
    }

    public enum CaloricLevel {DIET, NORMAL, FAT}
}
