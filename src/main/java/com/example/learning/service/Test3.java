package com.example.learning.service;

public class Test3 {

    public static void main(String[] args) {

//        List<String> test = new ArrayList<>();
//
//
//        List<String> t = Arrays.asList("10", "44", "5", "1", "3", "22", "11", "2", "45").stream()
//                .map(a -> Integer.valueOf(a)).sorted().map(a -> a.toString()).collect(Collectors.toList());
//
//        System.out.println(t);


        int a = 12;
        System.out.println(a);
        process(a);
        System.out.println(a);


    }

    public static void process(int a){
        a++;
    }

}
