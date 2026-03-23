package com.cristislv1;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;

@DisplayName("EvenNumbers - Black-Box Tests (BBT)")
class EvenNumbersTest {

    private static final Duration TIMEOUT = Duration.ofSeconds(3);

    @Test
    @DisplayName("TC1: Empty array should return 0")
    @Description("An array with no elements should yield 0 even numbers")
    @Severity(SeverityLevel.CRITICAL)
    void testEmptyArray() {
        int[] arr = new int[30];
        assertTimeoutPreemptively(TIMEOUT, () -> {
            int result = EvenNumbers.determinaNrPare(0, arr);
            assertEquals(0, result);
        });
    }

    @Test
    @DisplayName("TC2: All even numbers")
    @Description("An array containing only even numbers should return the count of all elements")
    @Severity(SeverityLevel.CRITICAL)
    void testAllEvenNumbers() {
        int[] arr = {2, 4, 6, 8, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        assertTimeoutPreemptively(TIMEOUT, () -> {
            int result = EvenNumbers.determinaNrPare(5, arr);
            assertEquals(5, result);
        });
    }

    @Test
    @DisplayName("TC3: All odd numbers")
    @Description("An array containing only odd numbers should return 0")
    @Severity(SeverityLevel.CRITICAL)
    void testAllOddNumbers() {
        int[] arr = {1, 3, 5, 7, 9, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        assertTimeoutPreemptively(TIMEOUT, () -> {
            int result = EvenNumbers.determinaNrPare(5, arr);
            assertEquals(0, result);
        });
    }

    @Test
    @DisplayName("TC4: Boundary value - 0 is even")
    @Description("Zero is an even number and should be counted")
    @Severity(SeverityLevel.NORMAL)
    void testBoundaryZeroIsEven() {
        int[] arr = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        assertTimeoutPreemptively(TIMEOUT, () -> {
            int result = EvenNumbers.determinaNrPare(1, arr);
            assertEquals(1, result);
        });
    }

    @Test
    @DisplayName("TC5: Boundary value - large even number")
    @Description("Very large even natural number should be counted")
    @Severity(SeverityLevel.NORMAL)
    void testBoundaryLargeEvenNumber() {
        int[] arr = {Integer.MAX_VALUE - 1, 2, 1000000, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        assertTimeoutPreemptively(TIMEOUT, () -> {
            int result = EvenNumbers.determinaNrPare(3, arr);
            assertEquals(3, result);
        });
    }

    @Test
    @DisplayName("TC6: Boundary value - large odd number")
    @Description("Integer.MAX_VALUE is odd and should not be counted")
    @Severity(SeverityLevel.NORMAL)
    void testBoundaryLargeOddNumber() {
        int[] arr = {Integer.MAX_VALUE, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        assertTimeoutPreemptively(TIMEOUT, () -> {
            int result = EvenNumbers.determinaNrPare(1, arr);
            assertEquals(0, result);
        });
    }

    @Test
    @DisplayName("TC7: Mixed even and odd numbers")
    @Description("Array with a mix of even and odd numbers should return correct even count")
    @Severity(SeverityLevel.CRITICAL)
    void testMixedEvenOdd() {
        int[] arr = {1, 2, 3, 4, 5, 6, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        assertTimeoutPreemptively(TIMEOUT, () -> {
            int result = EvenNumbers.determinaNrPare(6, arr);
            assertEquals(3, result);
        });
    }

    @Test
    @DisplayName("TC8: Single even element")
    @Description("Array with a single even element should return 1")
    @Severity(SeverityLevel.NORMAL)
    void testSingleEvenElement() {
        int[] arr = {2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        assertTimeoutPreemptively(TIMEOUT, () -> {
            int result = EvenNumbers.determinaNrPare(1, arr);
            assertEquals(1, result);
        });
    }

    @Test
    @DisplayName("TC9: Single odd element")
    @Description("Array with a single odd element should return 0")
    @Severity(SeverityLevel.NORMAL)
    void testSingleOddElement() {
        int[] arr = {3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        assertTimeoutPreemptively(TIMEOUT, () -> {
            int result = EvenNumbers.determinaNrPare(1, arr);
            assertEquals(0, result);
        });
    }

    @Test
    @DisplayName("TC10: Maximum array size (LIM=30)")
    @Description("Array at the maximum allowed size with mixed values")
    @Severity(SeverityLevel.NORMAL)
    void testMaxArraySize() {
        int[] arr = {2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31};
        assertTimeoutPreemptively(TIMEOUT, () -> {
            int result = EvenNumbers.determinaNrPare(30, arr);
            assertEquals(15, result);
        });
    }
}
