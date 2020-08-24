package com.example.demo;


import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @description: TODO
 * @author: zgf
 * @time: 2020/8/22 11:11
 */

public class LambdaTest {

    @Test
    public void getKeySet() {
        Map<String, String> map = new HashMap<>();
        map.put("a", "a");
        map.put("b", "b");
        map.put("c", "c");
        map.put("d", "d");

        System.out.println("map普通方式遍历:");
        for (String key : map.keySet()) {
            System.out.println("k=" + key + "，v=" + map.get(key));
        }
    }

    @Test
    public void getForEachMap() {
        Map<String, String> map = new HashMap<>();
        map.put("a", "a");
        map.put("b", "b");
        map.put("c", "c");
        map.put("d", "d");
        map.forEach((k, v) -> System.out.println(k + "-" + "-" + v));
        System.out.println("map拉姆达表达式遍历:");
        map.forEach((k, v) -> System.out.println("k=" + k + "，v=" + v));
    }

    @Test
    public void getForEachList() {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("bb");
        list.add("ccc");
        list.add("dddd");
        System.out.println("list拉姆达表达式遍历:");
        list.forEach(v ->
                System.out.println(v)
        );
        System.out.println("list双冒号运算符遍历:");
        list.forEach(System.out::println);
    }

    @Test
    public void getForEachListFilter() {
        List<String> list = Arrays.asList("张三", "李四", "王五", "xuwujing");
        System.out.println("过滤之前:" + list);
        List<String> result = new ArrayList<>();
        for (String str : list) {
            if (!"李四".equals(str)) {
                result.add(str);
            }
        }
        System.out.println("过滤之后:" + result);
    }


    @Test
    public void getForEachListFilterStream() {
        List<String> list = Arrays.asList("张三", "李四", "王五", "xuwujing");

        List<String> result2 = list.stream().filter(str -> !"李四".equals(str)).collect(Collectors.toList());
        ArrayList<Object> objects = new ArrayList<>();
        result2.forEach(k-> System.out.println("stream 过滤之后:"+k));
        System.out.println("stream 过滤之后:" + result2);
    }


}
