package com.genezeiniss.big_o_notation;

// O(log n): Logarithmic Time Complexity
public class LogarithmicTimeExample {

    public static void main(String[] args) {
        var totalPages = 1000;
        var targetPage = 512;

        var checks = binarySearch(totalPages, targetPage);
        System.out.printf("Number of checks needed: %s\n", checks);
    }

    public static int binarySearch(int totalPages, int targetPage) {
        int low = 1;
        int high = totalPages;
        int checks = 0;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            checks++; // Counting the number of checks

            switch (Integer.compare(mid, targetPage)) {
                case 0:
                    return checks;
                case -1:
                    low = mid + 1;
                    break;
                case 1:
                    high = mid - 1;
                    break;
            }
        }

        return -1; // Page not found
    }
}
