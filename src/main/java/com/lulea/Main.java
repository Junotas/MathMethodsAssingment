package com.lulea;

import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);

    // Pseudocode:
    // 1. Repeatedly ask user for radius and height until 'q' is entered.
    //    - Calculate and print circle area, cone area, and cone volume.
    // 2. Then ask for numerator and denominator until 'q'.
    //    - Call fraction(), print result using printFraction().

    public static double area(final int radius) {
        return Math.PI * Math.pow(radius, 2);
    }

    public static double pythagoras(final int sideA, final int sideB) {
        return Math.sqrt(Math.pow(sideA, 2) + Math.pow(sideB, 2));
    }

    public static double area(final int radius, final int height) {
        double s = pythagoras(radius, height);
        return Math.PI * radius * s;
    }

    public static double volume(final int radius, final int height) {
        return (1.0 / 3) * Math.PI * Math.pow(radius, 2) * height;
    }

    public static int gcd(final int a, final int b) {
        int x = Math.abs(a);
        int y = Math.abs(b);
        if (x < y) {
            int temp = x;
            x = y;
            y = temp;
        }
        while (y != 0) {
            int c = x % y;
            x = y;
            y = c;
        }
        return x;
    }

    public static int[] fraction(final int numerator, final int denominator) {
        if (denominator == 0) return null;
        if (numerator == 0) return new int[] {0, 0, 0};

        int intPart = numerator / denominator;
        int rem = numerator % denominator;
        int d = gcd(rem, denominator);
        return new int[] {intPart, rem / d, denominator / d};
    }

    public static void printFraction(final int[] parts) {
        if (parts == null) {
            System.out.println("Error");
        } else if (parts[0] == 0 && parts[1] == 0) {
            System.out.println("0");
        } else if (parts[0] == 0) {
            System.out.println(parts[1] + "/" + parts[2]);
        } else if (parts[1] == 0) {
            System.out.println(parts[0]);
        } else {
            System.out.println(parts[0] + " " + parts[1] + "/" + parts[2]);
        }
    }

    public static int input() {
        while (scanner.hasNext()) {
            if (scanner.hasNextInt()) {
                int val = scanner.nextInt();
                return Math.abs(val);
            } else {
                String s = scanner.next();
                if (s.equalsIgnoreCase("q")) {
                    return -1;
                }
                // ignore invalid input
            }
        }
        return -1;
    }

    // Main method is provided in CodeGrade
}
