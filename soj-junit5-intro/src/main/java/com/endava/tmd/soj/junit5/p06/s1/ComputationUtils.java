package com.endava.tmd.soj.junit5.p06.s1;

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
        long s = (long) a + b;
        if (s < Integer.MIN_VALUE || s > Integer.MAX_VALUE) {
            throw new ArithmeticException("Overflow while computing the sum");
        }
        return (int) s;
    }

}