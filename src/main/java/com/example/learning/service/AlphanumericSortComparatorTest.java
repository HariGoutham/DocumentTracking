package com.example.learning.service;

import java.util.Arrays;
import java.util.Comparator;

public final class AlphanumericSortComparatorTest<T> implements  Comparator<T> {

    public static final Comparator<String> NUMERICAL_ORDER
            = new AlphanumericSortComparatorTest<>(false);
    public static final Comparator<String> CASE_INSENSITIVE_NUMERICAL_ORDER
            = new AlphanumericSortComparatorTest<>(true);

    private final boolean caseInsensitive;

    private AlphanumericSortComparatorTest(boolean caseInsensitive) {
        this.caseInsensitive = caseInsensitive;
    }

    int compareRight(String a, String b) {
        int bias = 0;
        int ia = 0;
        int ib = 0;

        for (;; ia++, ib++) {
            char ca = charAt(a, ia);
            char cb = charAt(b, ib);
            if (bothCharactersAreNotDigit(ca,cb)) {
                return bias;
            } else if (!Character.isDigit(ca)) {
                return -1;
            } else if (!Character.isDigit(cb)) {
                return +1;
            } else if (isDigitLessThan(ca,cb,bias)) {
                    bias = -1;
            } else if (isDigitGreaterThan(ca,cb,bias)) {
                    bias = +1;
            } else if (isDigitEqual(ca,cb)) {
                return bias;
            }
        }
    }

    public int compare(T o1, T o2) {
        String a = o1.toString();
        String b = o2.toString();

        int ia = 0;
        int ib = 0;
        char ca;
        char cb;

        while (true) {
            ca = charAt(a, ia);
            cb = charAt(b, ib);
            while (isCharIsZero(ca)) {
                if (checkIsDigit(a,ia))
                    break;
                ca = charAt(a, ++ia);
            }
            while (isCharIsZero(cb)) {
                if (checkIsDigit(b,ib))
                    break;
                cb = charAt(b, ++ib);
            }
            if (checkIsDigitAndCompareRight(ca,cb,a,b,ia,ib)) {
                    return compareRight(a.substring(ia), b.substring(ib));
            }
            if (isDigitEqual(ca,cb)) {
                return getDifference(ca,cb);
            }
            if (checkCharLessThan(ca,cb)) {
                return -1;
            } else if (checkCharGreaterThan(ca,cb)) {
                return +1;
            }
            ++ia;
            ++ib;
        }
    }

    private boolean isCharIsZero(char ch){
        return  ch == '0';
    }

    private int getDifference(int a, int b){
        return a-b;
    }


    private boolean checkCharLessThan(char a, char b){
        return a < b;
    }

    private boolean checkCharGreaterThan(char a, char b){
        return a > b;
    }


    private boolean checkIsDigit(String a,int ia){
        return !Character.isDigit(charAt(a, ia+1));
    }


    private boolean checkIsDigitAndCompareRight(char ca, char cb, String a, String b, int ia, int ib){
        return Character.isDigit(ca) && Character.isDigit(cb) && compareRight(a.substring(ia), b.substring(ib)) != 0;
    }


    private char charAt(String s, int i) {
        return i >= s.length() ? 0 : getCharBasedOnCaseSensitivity(s, i);
    }

    private char getCharBasedOnCaseSensitivity(String s, int i) {
        return caseInsensitive ? Character.toUpperCase(s.charAt(i)) : s.charAt(i);
    }

    public boolean bothCharactersAreNotDigit(char ca, char cb)
    {
        return !Character.isDigit(ca) && !Character.isDigit(cb);
    }

    public boolean isDigitLessThan(char ca, char cb, int bias){
        return ca < cb && bias == 0;
    }

    public boolean isDigitGreaterThan(char ca, char cb, int bias){
        return ca > cb && bias == 0;
    }

    public boolean isDigitEqual(char ca, char cb){
        return ca == 0 && cb == 0;
    }


    public static void main(String[] args) {
        Comparator<String> numericalOrder
                = AlphanumericSortComparatorTest.NUMERICAL_ORDER;

        {
            String[] arr = {"10", "1", "2"};
            System.out.println("# Example 2");
            // [10, 1, 2]
            System.out.println(Arrays.toString(arr));
            Arrays.sort(arr, numericalOrder);
            // [1, 2, 10]
            System.out.println(Arrays.toString(arr));
        }

        {
            String[] examples = {"7438uiop43","10.1", "1.1", "Site-5", "12.1", "Site-10","2.2", "Tem464yy","Tem462yy","Alpha2", "AA22","74211ytpo99", "Site-7", "1-Site", "Gem-54","Site-2", "Site-3", "5", "Site-1", "Site-59", "10","Site-20", "Site-35","Site-22","Site-20","Site-2"
                    ,"10-Site","Gem-44","1", "324ytr423"};
            System.out.println("# Example 3");
            // [10, 1, 2]
            System.out.println(Arrays.toString(examples));
            Arrays.sort(examples, numericalOrder);
            // [1, 2, 10]
            System.out.println(Arrays.toString(examples));
        }
    }
}
