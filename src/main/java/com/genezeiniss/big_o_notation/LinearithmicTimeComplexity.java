package com.genezeiniss.big_o_notation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// O(n log n): Linearithmic Time Complexity
public class LinearithmicTimeComplexity {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(38, 27, 43, 3, 9, 82, 10);
        System.out.printf("Original list: %s\n", list);

        List<Integer> sortedList = mergeSort(list);
        System.out.printf("Sorted list: %s\n", sortedList);
    }

    public static List<Integer> mergeSort(List<Integer> list) {
        // Base case: a list with zero or one element is already sorted
        if (list.size() <= 1) {
            return list;
        }

        // Divide: The dataset is repeatedly divided in half until each sub-array contains a single element.
        // The number of times you can divide n elements in half is log(n).
        int middle = list.size() / 2;
        List<Integer> left = list.subList(0, middle);
        List<Integer> right = list.subList(middle, list.size());

        // Conquer: Each of these single-element arrays is trivially sorted.
        left = mergeSort(left);
        right = mergeSort(right);

        // Combine: The sorted sub-arrays are merged back together.
        // Merging n elements requires linear time, O(n).
        return merge(left, right);
    }

    public static List<Integer> merge(List<Integer> left, List<Integer> right) {
        List<Integer> result = new ArrayList<>();
        int leftIndex = 0, rightIndex = 0;

        // Merge the two lists while there are elements in both
        while (leftIndex < left.size() && rightIndex < right.size()) {
            if (left.get(leftIndex) <= right.get(rightIndex)) {
                result.add(left.get(leftIndex++));
            } else {
                result.add(right.get(rightIndex++));
            }
        }

        // If there are remaining elements in the left list, add them
        while (leftIndex < left.size()) {
            result.add(left.get(leftIndex++));
        }

        // If there are remaining elements in the right list, add them
        while (rightIndex < right.size()) {
            result.add(right.get(rightIndex++));
        }

        return result;
    }
}
