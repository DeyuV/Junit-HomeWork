package com.endava.tmd.soj.junit5.p03.s1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

// Provocare: Copiati metodele de test din tema anterioara, si adaugati adnotarile necesare astfel incat
// sa fie rulate testele in ordine alfabetica. Modificati numele metodelor de test astfel incat metodele
// sa fie executate in ordinea in care sunt scrise
@DisplayName("Tests for my sum method")
@TestMethodOrder(MethodOrderer.MethodName.class)

class ComputationUtilsTest {
    @Test
    @DisplayName("0 + 0 = 0")
    void AzeroShouldNotChangeZero() {
        // JUnit Assertion
        assertEquals(0, ComputationUtils.sum(0, 0));
        //assertEquals(1, ComputationUtils.sum(0, 0));

        // AssertJ Assertion
        assertThat(ComputationUtils.sum(0, 0)).isZero();
    }
    @Test
    @DisplayName("0 + 2 = 2")
    void BzeroShouldNotChangePositive() {
        assertEquals(2, ComputationUtils.sum(0, 2));
    }
    @Test
    @DisplayName("0 - 1 = -1")
    void CzeroShouldNotChangeNegative() {
        assertEquals(-1, ComputationUtils.sum(0, -1));
    }
    @Test
    @DisplayName("5 + 6 = 11")
    void DtwoPositiveNumbersShouldHaveAbsoluteValuesAddedAndPositiveResult() {
        assertEquals(11, ComputationUtils.sum(5, 6));
    }
    @Test
    @DisplayName("-10 - 2= -12")
    void EtwoNegativeNumbersShouldHaveAbsoluteValuesAddedAndNegativeResult() {
        assertEquals(-12, ComputationUtils.sum(-10, -2));
    }
    @Test
    @DisplayName("9 - 1 = 8")
    void FoneSmallNegativeAndOneBigPositiveNumberShouldHaveAbsoluteValuesSubtractedAndPositiveResult() {
        assertEquals(8, ComputationUtils.sum(-1, 9));
    }
    @Test
    @DisplayName("1 - 9 = -8")
    void GoneBigNegativeAndOneSmallPositiveNumberShouldHaveAbsoluteValuesSubtractedAndNegativeResult() {
        assertEquals(-8, ComputationUtils.sum(-9, 1));
    }
}
