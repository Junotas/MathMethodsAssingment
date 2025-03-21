package com.lulea;
import java.util.Scanner;

// Please don't forget to add pseudocode to your methods and classes.
public class Main {
    //Creation of scanner object.
    private static final Scanner userInputScanner = new Scanner(System.in);

    //Constants
    static final int QUIT = -1;

    public static void main(final String[] args) {
        int radius;
        int height;
        int numerator;
        int denominator;

        //Print the header of the program for area and volume.
        System.out.println("----------------------------------");
        System.out.println("# Test of area and volume methods");
        System.out.println("----------------------------------");

        // While loop that runs until user enters "q" for area and volume.
        while (true) {
            radius = input();
            if (radius == QUIT) {
                break;
            }

            height = input();
            if (height == QUIT) {
                break;
            }

            System.out.println("r = " + radius + ", h = " + height);
            System.out.printf("Circle area: %.2f %n", area(radius));
            System.out.printf("Cone area: %.2f %n", area(radius, height));
            System.out.printf("Cone volume: %.2f %n", volume(radius, height));
        }

        //Print the header of the program for area and volume.
        System.out.println("----------------------------------");
        System.out.println("# Test of the fractional methods");
        System.out.println("----------------------------------");

        // While loop that runs until user enters "q" for the fraction part
        while (true) {
            numerator = input();
            if (numerator == QUIT) {
                break;
            }

            denominator = input();
            if (denominator == QUIT) {
                break;
            }

            System.out.printf("%d/%d = ", numerator, denominator);
            printFraction(fraction(numerator, denominator));
        }
    }

    // --- YOUR IMPLEMENTATION GOES BELOW THIS LINE ---

    // Calculates the area of a circle using A = πr²
    public static double area(final int radius) {
        return Math.PI * Math.pow(radius, 2);
    }

    // Calculates the lateral surface area of a cone A = πrs where s = hypotenuse
    public static double area(final int radius, final int height) {
        double s = pythagoras(radius, height);
        return Math.PI * radius * s;
    }

    // Calculates hypotenuse using Pythagoras’ theorem: √(a² + b²)
    public static double pythagoras(final int sideA, final int sideB) {
        return Math.sqrt(Math.pow(sideA, 2) + Math.pow(sideB, 2));
    }

    // Calculates the volume of a cone using V = (1/3)πr²h
    public static double volume(final int radius, final int height) {
        return (1.0 / 3) * Math.PI * Math.pow(radius, 2) * height;
    }

    // Reduces a fraction and returns {integer part, numerator, denominator}
    public static int[] fraction(final int numerator, final int denominator) {
        if (denominator == 0) {
            return null;
        }
        if (numerator == 0) {
            return new int[]{0, 0, 0};
        }

        int intPart = numerator / denominator;
        int fracNumerator = numerator % denominator;
        int fracDenominator = denominator;

        int gcd = gcd(fracNumerator, fracDenominator);
        fracNumerator /= gcd;
        fracDenominator /= gcd;

        return new int[]{intPart, fracNumerator, fracDenominator};
    }

    // Calculates the Greatest Common Divisor using Euclid's algorithm
    public static int gcd(final int a, final int b) {
        int x = Math.abs(a);
        int y = Math.abs(b);
        if (x < y) {
            int temp = x;
            x = y;
            y = temp;
        }

        while (y != 0) {
            int temp = x % y;
            x = y;
            y = temp;
        }
        return x;
    }

    // Prints a reduced fraction in human-readable form
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

    // Reads input from user, returns a non-negative int or -1 if 'q' is entered
    public static int input() {
        while (userInputScanner.hasNext()) {
            if (userInputScanner.hasNextInt()) {
                return Math.abs(userInputScanner.nextInt());
            } else {
                String token = userInputScanner.next();
                if (token.equalsIgnoreCase("q")) {
                    return QUIT;
                }
                // Ignore invalid non-integer inputs
            }
        }
        return QUIT;
    }
}
