package com.endava.tmd.soj.junit5.p05.s1;

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
        if (a > 0) {
            if (b > 0) {
                if (a <= Integer.MAX_VALUE - b) {
                    return a + b;
                } else {
                    throw new ArithmeticException("Overflow while computing the sum");
                }
            } else {
                return a + b;
            }
        } else {
            if (b >= 0) {
                return a + b;
            } else {
                if (a >= Integer.MIN_VALUE - b) {
                    return a + b;
                } else {
                    throw new ArithmeticException("Overflow while computing the sum");
                }
            }
        }
    }

}