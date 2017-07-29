package com.guwr.jdk8.chap6;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by   guwr
 * Project_name jdk8
 * Path         com.guwr.jdk8.chap4.Chapter6
 * Date         2017/7/21
 * Time         13:21
 * Description
 */
public class Chapter6 {
    public static void main(String[] args) {
        //按照食品不同类型分组
        Map<Dish.Type, List<Dish>> map = Dish.menu.stream().collect(Collectors.groupingBy(Dish::getType));

        System.out.println("map = " + map);
    }
}
