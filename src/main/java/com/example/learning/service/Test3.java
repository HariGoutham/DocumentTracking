package com.example.learning.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Test3 {

    public static void main(String[] args) {

        List<String> test = new ArrayList<>();


        List<String> t = Arrays.asList("10", "44", "5", "1", "3", "22", "11", "2", "45").stream()
                .map(a -> Integer.valueOf(a)).sorted().map(a -> a.toString()).collect(Collectors.toList());

        System.out.println(t);


    }
}
