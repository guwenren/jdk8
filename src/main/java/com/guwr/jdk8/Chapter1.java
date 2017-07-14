package com.guwr.jdk8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by guwr
 * Project_name jdk8
 * Path com.guwr.jdk8.Chapter1
 * Date 17/7/1
 * Time 下午10:34
 * Description
 */
public class Chapter1 {
    public static void main(String[] args) {
        List<Apple> inventory = Arrays.asList(new Apple(80, "green"), new Apple(155, "green"), new Apple(120, "red"));

        List<Apple> collect = inventory.stream().filter(item -> item.getWeight() > 90).collect(Collectors.toList());

        collect.forEach(System.out::println);

        System.out.println("---------------------------");

        List<Apple> collect1 = inventory.parallelStream().filter(item -> item.getWeight() > 90).collect(Collectors.toList());

        collect1.forEach(System.out::println);

        List<Apple> apples = filterGreenApples(inventory);

        System.out.println("apples = " + apples);

        List<Apple> apples1 = filterApplesByColor(inventory,"red");

        System.out.println("apples1 = " + apples1);
    }

    public static List<Apple> filterGreenApples(List<Apple> inventory) {
        List<Apple> result = new ArrayList<Apple>();
        for (Apple apple : inventory) {
            if ("green".equals(apple.getColor())) {
                result.add(apple);
            }
        }
        return result;
    }

    public static List<Apple> filterApplesByColor(List<Apple> inventory,
                                                  String color) {
        List<Apple> result = new ArrayList<Apple>();
        for (Apple apple: inventory){
            if ( apple.getColor().equals(color) ) {
                result.add(apple);
            }
        }
        return result;
    }
}
