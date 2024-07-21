package com.genezeiniss.big_o_notation;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

// O(n): Linear Time Complexity
public class LinearTimeExample {

    public static void main(String[] args) {
        // Simulating a book with 1000 pages
        List<String> book = IntStream.range(0, 1000)
                .mapToObj(LinearTimeExample::toChineseNumber)
                .collect(Collectors.toList());

        // The page we want to find (e.g., page 512 in Chinese characters)
        String targetPage = toChineseNumber(512);

        // Performing the linear search
        int checks = linearSearch(book, targetPage);
        System.out.printf("Number of checks needed: %s\n", checks);
    }

    public static int linearSearch(List<String> book, String targetPage) {
        int checks = 0;

        for (String page : book) {
            checks++;
            if (page.equals(targetPage)) {
                return checks;
            }
        }

        return -1; // Page not found
    }

    private static String toChineseNumber(int number) {
        List<String> units = List.of("", "十", "百", "千", "万"); // This list contains Chinese characters for units like ten, hundred, thousand, and ten thousand.
        List<String> digits = List.of("零", "一", "二", "三", "四", "五", "六", "七", "八", "九"); // This array contains Chinese characters for the digits 0 through 9.

        // If the input number is zero, the function directly returns "零", which is the Chinese character for zero.
        if (number == 0) {
            return digits.get(0);
        }

        StringBuilder chineseNumber = new StringBuilder();
        int unitIndex = 0;

        // The function uses a loop to process each digit of the input number from right to left.
        while (number > 0) {
            int digit = number % 10; //  Extracts the rightmost digit of the number.
            if (digit != 0) { // If the digit is not zero, it prepends the corresponding Chinese digit and unit to the StringBuilder.
                chineseNumber.insert(0, digits.get(digit) + units.get(unitIndex));
            } else if (chineseNumber.length() > 0 && chineseNumber.charAt(0) != '零') { // If the digit is zero and the current Chinese number being built doesn't already start with zero, it prepends "零".
                chineseNumber.insert(0, digits.get(digit));
            }
            number /= 10; // Removes the rightmost digit from the number
            unitIndex++; // Moves to the next unit (ten, hundred, thousand, etc.)
        }

        return chineseNumber.toString();
    }
}
