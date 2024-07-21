package com.genezeiniss.big_o_notation;

import java.util.stream.IntStream;

// O(2^n): Exponential Time Complexity
public class ExponentialTimeComplexity {

    public static void main(String[] args) {
        // Example: Calculate and print the first 10 Fibonacci numbers
        int n = 10;
        System.out.printf("Fibonacci sequence up to %s terms: ", n);

        IntStream.range(0, n)
                .mapToObj(i -> fibonacci(i) + " ")
                .forEach(System.out::print);
    }

    public static int fibonacci(int n) {
        return n <= 1 ? n : fibonacci(n - 1) + fibonacci(n - 2);
    }
}
