package com.genezeiniss.big_o_notation;

import java.util.ArrayList;
import java.util.List;

// O(n!): Factorial Time Complexity
public class FactorialTimeComplexity {

    public static void main(String[] args) {
        List<Integer> nums = List.of(1, 2, 3);
        List<List<Integer>> permutations = permute(new ArrayList<>(nums));
        System.out.printf("Permutations of %s:\n", nums);
        permutations.forEach(System.out::println);
    }

    // Method to generate all permutations of a list
    public static List<List<Integer>> permute(List<Integer> nums) {
        List<List<Integer>> result = new ArrayList<>();
        permuteHelper(nums, 0, result);
        return result;
    }

    // Helper method to generate permutations recursively
    private static void permuteHelper(List<Integer> nums, int start, List<List<Integer>> result) {
        if (start == nums.size() - 1) {
            result.add(new ArrayList<>(nums));
            return;
        }
        for (int i = start; i < nums.size(); i++) {
            swap(nums, i, start);
            permuteHelper(nums, start + 1, result);
            swap(nums, i, start); // backtrack
        }
    }

    // Method to swap elements in a list
    private static void swap(List<Integer> nums, int i, int j) {
        int temp = nums.get(i);
        nums.set(i, nums.get(j));
        nums.set(j, temp);
    }
}
