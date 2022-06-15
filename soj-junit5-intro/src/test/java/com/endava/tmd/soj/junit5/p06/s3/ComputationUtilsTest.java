package com.endava.tmd.soj.junit5.p06.s3;

import com.endava.tmd.soj.junit5.p06.s3.ComputationUtils;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.params.provider.Arguments.arguments;

// Provocare: Rescrieti cele doua teste parametrizate din sectiunea 1 astfel incat sa existe
// cate o metoda care sa furnizeze valorile parametrilor. Dar, nu se vor mai folosi valorile
// explicite pentru valoarea minima si maxima acceptata de Java pentru tipul de date intreg,
// ci se vor folosi Integer.MIN_VALUE, respectiv Integer.MAX_VALUE
// Se va utiliza adnotarea @MethodSource.
@DisplayName("Tests for my sum method")
class ComputationUtilsTest {

    @DisplayName("a + b")
    @ParameterizedTest
    @MethodSource("param")
    void sumOfTwoNumbers(Integer a, Integer b, Integer c){
        assertEquals(c, ComputationUtils.sum(a, b));
    }
    static Stream<Arguments> param(){
        return Stream.of(arguments(Integer.MAX_VALUE,Integer.MIN_VALUE,-1));
    }
    @Test
    @DisplayName("0 + 0 = 0")
    void zeroShouldNotChangeZero() {
        // JUnit Assertion
        assertEquals(0, ComputationUtils.sum(0, 0));
        //assertEquals(1, ComputationUtils.sum(0, 0));

        // AssertJ Assertion
        assertThat( ComputationUtils.sum(0, 0)).isZero();
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
        assertEquals(11,ComputationUtils.sum(5, 6));
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

    @ParameterizedTest
    @MethodSource("param")
    @DisplayName("2147483647 + 1 \u21D2 Overflow")
    void exceptionWhenSumIsGreaterThanIntegerMaxValue(Integer a, Integer b, Integer c) {
        // JUnit way of checking the exception class
        assertThrows(ArithmeticException.class, () -> ComputationUtils.sum(a, -c));

        // JUnit way of checking the exception class and its characteristics
        ArithmeticException exception = assertThrows(ArithmeticException.class, () -> ComputationUtils.sum(a, a));
        assertEquals("Overflow while computing the sum", exception.getMessage());

        // AssertJ
        assertThatThrownBy(() -> ComputationUtils.sum(a, -c))
                .isInstanceOf(ArithmeticException.class)
                .hasMessage("Overflow while computing the sum");
    }

    @DisplayName("-2147483648 + (-1) \u21D2 Overflow")
    void exceptionWhenSumIsLowerThanIntegerMinValue() {
    }

}
