package com.example.learning.service;

import java.util.Arrays;
import java.util.Comparator;

// Java alphanumeric sort
// unsorted array:     [10, 1, 2]
// simple Arrays.sort: [1, 10, 2]
// alphanumeric sort:  [1, 2, 10]
//
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

            if (!Character.isDigit(ca) && !Character.isDigit(cb)) {
                return bias;
            } else if (!Character.isDigit(ca)) {
                return -1;
            } else if (!Character.isDigit(cb)) {
                return +1;
            } else if (ca < cb) {
                if (bias == 0) {
                    bias = -1;
                }
            } else if (ca > cb) {
                if (bias == 0)
                    bias = +1;
            } else if (ca == 0 && cb == 0) {
                return bias;
            }
        }
    }

    public int compare(T o1, T o2) {
        String a = o1.toString();
        String b = o2.toString();

        int ia = 0;
        int ib = 0;
        int nza = 0;
        int nzb = 0;
        char ca, cb;
        int result;

        while (true) {
            nza = 0;
            nzb = 0;
            ca = charAt(a, ia);
            cb = charAt(b, ib);
            while (ca == '0') {
                nza++;
                if (!Character.isDigit(charAt(a, ia+1)))
                    break;
                ca = charAt(a, ++ia);
            }
            while (cb == '0') {
                nzb++;
                if (!Character.isDigit(charAt(b, ib+1)))
                    break;
                cb = charAt(b, ++ib);
            }
            if (Character.isDigit(ca) && Character.isDigit(cb)) {
                if ((result = compareRight(a.substring(ia), b
                        .substring(ib))) != 0) {
                    return result;
                }
            }
            if (ca == 0 && cb == 0) {
                return nza - nzb;
            }
            if (ca < cb) {
                return -1;
            } else if (ca > cb) {
                return +1;
            }
            ++ia;
            ++ib;
        }
    }

    private char charAt(String s, int i) {
        if (i >= s.length()) {
            return 0;
        } else {
            return caseInsensitive ?
                    Character.toUpperCase(s.charAt(i)) : s.charAt(i);
        }
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
