package com.endava.tmd.soj.junit5.p06.s1;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;


import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

// Provocare: Rescrieti scenariile de testare din tema precedenta folosind teste parametrizate.
// Se vor utiliza adnotarile @ParameterizedTest si @CsvSource
// E suficient sa scrieti 2 teste distincte:
// - Un test care verifica valoarea sumei a doua numere
// - Un test care verifica exceptiile generate
//
// Bonus: personalizarea numelui afisat al testului
//   * vom folosi {0} pentru a folosi valoarea primului parametru al metodei
//   * vom folosi {1} pentru a folosi valoarea celui de-al doilea parametru al metodei
//   * ...
//   dar NU in @DisplayName ci in atributul "name" al adnotarii @ParameterizedTest
@DisplayName("Tests for my sum method")
class ComputationUtilsTest {
    @DisplayName("a + b")
    @ParameterizedTest(name = "{0} + {1} = {2}")
    @CsvSource({
            "9, 2, 11"
    })
    void sumOfTwoNumbers(int a, int b, int c){
        assertEquals(c, ComputationUtils.sum(a, b));
    }
    @Test
    @DisplayName("0 + 0 = 0")
    void zeroShouldNotChangeZero() {
        // JUnit Assertion
        assertEquals(0, ComputationUtils.sum(0, 0));
        //assertEquals(1, ComputationUtils.sum(0, 0));

        // AssertJ Assertion
        assertThat(ComputationUtils.sum(0, 0)).isZero();
    }

    @Test
    @DisplayName("0 + 2 = 2")
    void zeroShouldNotChangePositive() {
        assertEquals(2, ComputationUtils.sum(0, 2));
    }

    @Test
    @DisplayName("0 - 1 = -1")
    void zeroShouldNotChangeNegative() {
        assertEquals(-1, ComputationUtils.sum(0, -1));
    }

    @Test
    @DisplayName("5 + 6 = 11")
    void twoPositiveNumbersShouldHaveAbsoluteValuesAddedAndPositiveResult() {
        assertEquals(11, ComputationUtils.sum(5, 6));
    }

    @Test
    @DisplayName("-10 - 2= -12")
    void twoNegativeNumbersShouldHaveAbsoluteValuesAddedAndNegativeResult() {
        assertEquals(-12, ComputationUtils.sum(-10, -2));
    }

    @Test
    @DisplayName("9 - 1 = 8")
    void oneSmallNegativeAndOneBigPositiveNumberShouldHaveAbsoluteValuesSubtractedAndPositiveResult() {
        assertEquals(8, ComputationUtils.sum(-1, 9));
    }

    @Test
    @DisplayName("1 - 9 = -8")
    void oneBigNegativeAndOneSmallPositiveNumberShouldHaveAbsoluteValuesSubtractedAndNegativeResult() {
        assertEquals(-8, ComputationUtils.sum(-9, 1));
    }

    @Test
    @DisplayName("0 + MAXINT = MAXINT")
    void zeroShouldNotChangeMaxInt() {
        assertEquals(Integer.MAX_VALUE, ComputationUtils.sum(0, Integer.MAX_VALUE));

    }

    @Test
    @DisplayName("MAXINT - 9 = MAXINT - 9")
    void maxIntAndANegativeNumber() {
        assertEquals(Integer.MAX_VALUE - 9, ComputationUtils.sum(-9, Integer.MAX_VALUE));

    }

    @Test
    @DisplayName("0 + MININT = MININT")
    void zeroShouldNotChangeMinInt() {
        assertEquals(Integer.MIN_VALUE, ComputationUtils.sum(0, Integer.MIN_VALUE));

    }

    @Test
    @DisplayName("MININT + 9 = MININT + 9")
    void minIntAndAPositiveNumber() {
        assertEquals(Integer.MIN_VALUE, ComputationUtils.sum(0, Integer.MIN_VALUE));

    }

    @Test
    @DisplayName("MININT + MAXINT = -1")
    void minIntAndMaxInt() {
        assertEquals(-1, ComputationUtils.sum(Integer.MIN_VALUE, Integer.MAX_VALUE));

    }

    @Test
    @DisplayName("SUM > MAXINT ???")
    @Disabled
    void whatToDoWhenSumExceedsMaxIntegerValue() {
        assertEquals(Integer.MAX_VALUE + 9, ComputationUtils.sum(9, Integer.MAX_VALUE));

    }


    @ParameterizedTest(name = "{0} + {1} \u21D2 Overflow")
    @CsvSource({
            "2147483647, 1"
    })
    void exceptionWhenSumIsGreaterThanIntegerMaxValue(int a, int b) {
        // JUnit way of checking the exception class
        assertThrows(ArithmeticException.class, () -> ComputationUtils.sum(a, b));

        // JUnit way of checking the exception class and its characteristics
        ArithmeticException exception = assertThrows(ArithmeticException.class, () -> ComputationUtils.sum(a, b));
        assertEquals("Overflow while computing the sum", exception.getMessage());

        // AssertJ
        assertThatThrownBy(() -> ComputationUtils.sum(a, b))
                .isInstanceOf(ArithmeticException.class)
                .hasMessage("Overflow while computing the sum");
    }

    @ParameterizedTest(name = "{0} + {1} \u21D2 Overflow")
    @CsvSource({
            "-2147483648, -1"
    })
    void exceptionWhenSumIsLowerThanIntegerMinValue(int a, int b) {
        // JUnit way of checking the exception class
        assertThrows(ArithmeticException.class, () -> ComputationUtils.sum(a, b));

        // JUnit way of checking the exception class and its characteristics
        ArithmeticException exception = assertThrows(ArithmeticException.class, () -> ComputationUtils.sum(a, b));
        assertEquals("Overflow while computing the sum", exception.getMessage());

        // AssertJ
        assertThatThrownBy(() -> ComputationUtils.sum(a, b))
                .isInstanceOf(ArithmeticException.class)
                .hasMessage("Overflow while computing the sum");
    }

}
