package com.guwr.jdk8.chap6;

import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.groupingBy;

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
            if (item.getCalories() <= 400) {
                return CaloricLevel.DIET;
            }
            return CaloricLevel.FAT;
        })));

        System.out.println("collect2 = " + collect2);

    }

    private static Map<Dish.Type, List<Dish>> groupDishesByType() {
        return null;
    }

    public enum CaloricLevel {DIET, NORMAL, FAT}
}
