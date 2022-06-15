package com.endava.tmd.soj.junit5.p05.s2;

public class ComputationUtils {

    private ComputationUtils() {
        // it is useless to instantiate this class
    }

    /**
     * Utility method to compute the sum of 2 integers
     * 
     * @param a First number
     * @param b Second number
     * @return The sum of the given numbers
     * @throws ArithmeticException in case the result exceeds the possible values for an integer
     */
    public static int sum(int a, int b) {
        if (a > b) {
            return orderedNumbersSum(b, a);
        }
        return orderedNumbersSum(a, b);
    }

    private static int orderedNumbersSum(int x, int y) {
        if (x > 0) {
            return orderedPositiveNumbersSum(x, y);
        } else {
            if (y >= 0) {
                return x + y;
            } else {
                return orderedNegativeNumbersSum(x, y);
            }
        }
    }

    private static int orderedPositiveNumbersSum(int x, int y) {
        if (x <= Integer.MAX_VALUE - y) {
            return x + y;
        } else {
            throw new ArithmeticException("Overflow while computing the sum");
        }
    }

    private static int orderedNegativeNumbersSum(int x, int y) {
        if (x >= Integer.MIN_VALUE - y) {
            return x + y;
        } else {
            throw new ArithmeticException("Overflow while computing the sum");
        }
    }

}