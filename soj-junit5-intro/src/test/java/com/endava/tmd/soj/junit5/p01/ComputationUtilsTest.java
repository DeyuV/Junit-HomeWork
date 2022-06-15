package com.endava.tmd.soj.junit5.p01;

// Provocari:
// 1. Adaugati adnotarea neecesara pentru a rula prima metoda ca si un test unitar
// 2. Rulati prima metoda ca si un test unitar
// 3. Decomentati asertiile din primul test, si efectuati importurile necesare. Rulati testul din nou.
// 4. Adaugati o linie care sa determine testul sa fie "failed". La sfarsit commentati acea linie
// 5. Completati celelalte metode astfel incat sa reprezinte scenarii de testare

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;


class ComputationUtilsTest {
    @Test
    void zeroShouldNotChangeZero() {
        // JUnit Assertion
        assertEquals(0, ComputationUtils.sum(0, 0));
        //assertEquals(1, ComputationUtils.sum(0, 0));

        // AssertJ Assertion
        assertThat(ComputationUtils.sum(0, 0)).isZero();
    }

    @Test
    void zeroShouldNotChangePositive() {
        assertEquals(2, ComputationUtils.sum(0, 2));
    }

    @Test
    void zeroShouldNotChangeNegative() {
        assertEquals(-1, ComputationUtils.sum(0, -1));
    }

    @Test
    void twoPositiveNumbersShouldHaveAbsoluteValuesAddedAndPositiveResult() {
        assertEquals(11, ComputationUtils.sum(5, 6));
    }

    @Test
    void twoNegativeNumbersShouldHaveAbsoluteValuesAddedAndNegativeResult() {
        assertEquals(-12, ComputationUtils.sum(-10, -2));
    }

    @Test
    void oneSmallNegativeAndOneBigPositiveNumberShouldHaveAbsoluteValuesSubtractedAndPositiveResult() {
        assertEquals(8, ComputationUtils.sum(-1, 9));
    }

    @Test
    void oneBigNegativeAndOneSmallPositiveNumberShouldHaveAbsoluteValuesSubtractedAndNegativeResult() {
        assertEquals(-8, ComputationUtils.sum(-9, 1));
    }

}
