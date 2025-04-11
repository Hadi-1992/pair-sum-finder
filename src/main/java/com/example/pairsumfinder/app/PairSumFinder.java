package com.example.pairsumfinder.app;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class PairSumFinder {

    public static void findPairs(List<Integer> nums, int x) {
        Set<Integer> pairs = new HashSet<>();
        // for remove duplicates
        Set<String> printedPairs = new HashSet<>();

        System.out.println("Pairs with sum " + x + ":");
        for (int num : nums) {
            int complement = x - num;
            if (pairs.contains(complement)) {
                int a = Math.min(num, complement);
                int b = Math.max(num, complement);
                String pairKey = a + "," + b;
                if (!printedPairs.contains(pairKey)) {
                    System.out.println("(" + a + ", " + b + ")");
                    printedPairs.add(pairKey);
                }
            }
            pairs.add(num);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter numbers separated by space:");
        String[] input = scanner.nextLine().split("\\s+");

        List<Integer> numbers = new ArrayList<>();
        for (String s : input) {
            try {
                numbers.add(Integer.parseInt(s));
            } catch (NumberFormatException e) {
                System.out.println("Invalid number: " + s);
                return;
            }
        }

        System.out.print("Enter target sum: ");
        int target = scanner.nextInt();

        findPairs(numbers, target);
    }
}
