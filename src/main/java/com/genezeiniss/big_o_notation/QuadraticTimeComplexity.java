package com.genezeiniss.big_o_notation;

import java.util.Arrays;
import java.util.List;

// O(n^2): Quadratic Time Complexity
public class QuadraticTimeComplexity {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(64, 34, 25, 12, 22, 11, 90);
        System.out.printf("Unsorted list: %s\n", list);

        bubbleSort(list);
        System.out.printf("Sorted list: %s\n", list);
    }

    public static void bubbleSort(List<Integer> list) {
        int n = list.size();
        boolean swapped;

        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            // Inner loop to perform the comparisons and swaps
            for (int j = 0; j < n - i - 1; j++) {
                // If the current element is greater than the next element, swap them
                if (list.get(j) > list.get(j + 1)) {
                    int temp = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, temp);
                    swapped = true;
                }
            }
            // If no elements were swapped during the inner loop, the array is sorted
            if (!swapped) break;
        }
    }
}
