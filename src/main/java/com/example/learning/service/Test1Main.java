package com.example.learning.service;

import com.example.learning.entity.DocumentEntity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class Test1Main {

    public static void main(String[] args){

        DocumentEntity documentEntity = new DocumentEntity();
        documentEntity.setName("site-10");
        documentEntity.setStudyName("Test");
        DocumentEntity documentEntity1 = new DocumentEntity();
        documentEntity1.setName("site-20");
        documentEntity1.setStudyName("Test1");
        List<DocumentEntity> t = Arrays.asList(documentEntity, documentEntity1);
        t.stream().forEach(a -> {
            System.out.println(a.getName());
            System.out.println(a.getStudyName());
        });

        t.stream().forEach(a-> a.setName(null));

        t.stream().forEach(a -> {
            System.out.println(a.getName());
            System.out.println(a.getStudyName());
        });

        System.out.println(checkIsValidFromToDate("From: 2022-03-17 To: 2022-03-18"));


    }

    private static boolean checkIsValidFromToDate(String dateFromAndTo) {
        String[] subStrings = dateFromAndTo.split(" ");
        String regexDateCheck = "^[0-9]{4}-(1[0-2]|0[1-9])-(3[01]|[12][0-9]|0[1-9])$";
        boolean isValidDateFromTo = true;
        if (!subStrings[0].equals("From:") || !subStrings[2].equals("To:") || !Pattern.matches(regexDateCheck, subStrings[1]) || !Pattern.matches(regexDateCheck, subStrings[3])) {
            return false;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
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
