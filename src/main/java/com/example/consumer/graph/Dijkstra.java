package com.example.consumer.graph;

import org.apache.commons.lang.time.DateUtils;

import java.util.*;

public class Dijkstra {
    public static void main(String[] args) {

//        Map<Object, Object> costs = new HashMap<>();
//        Map<Object, Object> parents = new HashMap<>();
//        Map<Object, Map<Object,Object>> graph = new HashMap<>();
//
//
//
//        Map<Object,Object> starts = new HashMap<>();
//        starts.put("A",6);
//        starts.put("B",2);
//
//        graph.put("start",starts);
//
//        graph.get("start").keySet().forEach(System.out::println);
//
//        Queue<Integer> left = new LinkedList<>();
//        Queue<Integer> right = new LinkedList<>();

        Date expirationDateStart = DateUtils.truncate(DateUtils.addDays(
                new Date(), 2), Calendar.DATE);
        Date expirationDateEnd = DateUtils.addDays(expirationDateStart,
                3);

        System.out.println(expirationDateStart);
        System.out.println(expirationDateEnd);
    }

}
