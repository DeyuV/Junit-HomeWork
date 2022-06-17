package com.endava.tmd.soj.junit5.p04;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

// Provocare: Copiati metodele de test din tema de la p02, si adaugati ceea ce lipseste astfel incat
// sa fie testate si scenariile urmatoare. La ultima metoda, in cazul in care testul nu trece,
// adaugati adnotarea necesara astfel incat sa apara ca si "skipped"
@DisplayName("Tests for my sum method")
class ComputationUtilsTest {

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

}
