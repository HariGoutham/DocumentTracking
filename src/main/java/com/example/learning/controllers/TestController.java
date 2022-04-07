package com.example.learning.controllers;

import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Field;

@RestController
public class TestController {

    public static int findMax(int arr[]){
        int max=arr[0];
        for(int i=1;i<arr.length;i++){
            if(max<arr[i])
                max=arr[i];
        }
        return max;
    }
}
