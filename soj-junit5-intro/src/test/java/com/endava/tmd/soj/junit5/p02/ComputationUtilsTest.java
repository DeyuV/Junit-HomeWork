package com.endava.tmd.soj.junit5.p02;

import com.endava.tmd.soj.junit5.p01.ComputationUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

// Provocare: Copiati metodele de test din tema anterioara, si adaugati adnotarile necesare astfel incat:
// 1. Sa fie afisat "Tests for my sum method" in loc de "ComputationUtilsTest"
// 2. La fiecare test sa fie afisata suma. De exemplu "zeroShouldNotChangeZero" ar trebui sa fie inlocuit cu "0 + 0 = 0"
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
}
