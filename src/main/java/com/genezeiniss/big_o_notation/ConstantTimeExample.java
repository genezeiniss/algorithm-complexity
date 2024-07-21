package com.genezeiniss.big_o_notation;

import java.util.List;

// O(1): Constant Time Algorithm
public class ConstantTimeExample {

    // Accessing an element at a specific index in an array is an O(1) operation
    // because it takes the same amount of time regardless of the array size.
    public void accessElement(List<Integer> elements, int index) {
        int element = elements.get(index);
        System.out.printf("Element at index %s: %s", index, element);
    }

    // Updating or assigning value to an array element at a specific index is also an O(1) operation because it takes constant time.
    public void updateElement(List<Integer> elements, int index) {
        elements.set(index, 100);
        System.out.printf("Updated element at index %s", index);
    }

    // Checking the length of an array is an O(1) operation because it's simply accessing a property of the array.
    public void checkLength(List<Integer> elements) {
        int length = elements.size();
        System.out.printf("Length of elements list is %s", length);
    }
}
