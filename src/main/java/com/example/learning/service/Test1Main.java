package com.example.learning.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.regex.Pattern;

public class Test1Main {

    public static void main(String[] args){

        System.out.println(checkIsValid("From: 16-06-2022 To: 16-03-2022"));
        System.out.println(checkIsValid("From: 16-06-2022 To: 16-03-2023"));
        System.out.println(checkIsValid("From:16-06-2022 To: 16-03-2023"));
        System.out.println(checkIsValid("From: 16-06-2022 To:16-03-2023"));
        System.out.println(checkIsValid("From: 16-fff06-2022 To: 16-03-2023"));
        System.out.println(checkIsValid("From: 16-06-2022 To: 16add-03-2023"));

    }

    private static boolean checkIsValid(String dateFromAndTo) {
        String[] subStrings = dateFromAndTo.split(" ");
        String regexDateCheck = "^(3[01]|[12][0-9]|0[1-9])-(1[0-2]|0[1-9])-[0-9]{4}$";
        boolean isValidDateFromTo = true;
        if (!subStrings[0].equals("From:") || !subStrings[2].equals("To:") || !Pattern.matches(regexDateCheck, subStrings[1]) || !Pattern.matches(regexDateCheck, subStrings[3])) {
            return false;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        try {
            if (sdf.parse(subStrings[1]).after(sdf.parse(subStrings[3]))) {
                isValidDateFromTo = false;
            }
        } catch (ParseException e) {
            isValidDateFromTo = false;
        }
        return isValidDateFromTo;
    }

}
