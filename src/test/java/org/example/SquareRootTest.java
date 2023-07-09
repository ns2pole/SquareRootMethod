package org.example;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.example.SquareRoot.*;

class SquareRootTest {

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
    }

    @org.junit.jupiter.api.Test
    void test_getIntegerPart() {
        assertEquals(31, getIntegerPart(1000));
    }

    @org.junit.jupiter.api.Test
    void test_getDigit() {
        assertEquals(6, getDigit(620, 3900));
    }

    @org.junit.jupiter.api.Test
    void test_getNextTargetNumFor() {
        assertEquals(500, getNextTargetNumFor(100, 105));
    }

    @org.junit.jupiter.api.Test
    void test_getSubstractNumFor() {
        assertEquals(3756, getSubstractNumFor(620, 3900));

    }

    @org.junit.jupiter.api.Test
    void test_getFirstGivenNumFor() {
        assertEquals(200, getFirstGivenNumFor(105));
    }

    @org.junit.jupiter.api.Test
    void test_getNextGivenNumFor() {
        assertEquals(6320, getNextGivenNumFor(620, 3900));
    }

    @org.junit.jupiter.api.Test
    void test_getDecimalPartFor() {
        ArrayList<Integer> expected = new ArrayList<>(Arrays.asList(6, 2, 2));
        ArrayList<Integer> actual = getDecimalPartFor(1000, 3);
        assertArrayEquals(expected.toArray(), actual.toArray());
    }

    @org.junit.jupiter.api.Test
    void test_getSquareRootFor() {
//        Decimal actual1 = getSquareRootFor(2, 12);
//        Decimal expected1 = new Decimal();
//        expected1.integerPart = 1;
//        expected1.decimalPart = new ArrayList<>(Arrays.asList(4, 1, 4, 2, 1, 3, 5, 6, 2, 3, 7, 3));
//        assertEquals(expected1, actual1);

        Decimal actual2 = getSquareRootFor(5, 17);
        Decimal expected2 = new Decimal();
        expected2.integerPart = 2;
        expected2.decimalPart = new ArrayList<>(Arrays.asList(2, 3, 6, 0, 6, 7, 9, 7, 7, 4, 9, 9, 7, 8, 9, 6, 9));
        assertEquals(expected2, actual2);

        Decimal actual3 = getSquareRootFor(111, 3);
        Decimal expected3 = new Decimal();
        expected3.integerPart = 10;
        expected3.decimalPart = new ArrayList<>(Arrays.asList(5, 3, 5));
        assertEquals(expected3, actual3);

        Decimal actual4 = getSquareRootFor(1000, 3);
        Decimal expected4 = new Decimal();
        expected4.integerPart = 31;
        expected4.decimalPart = new ArrayList<>(Arrays.asList(6, 2, 2));
        assertEquals(expected4, actual4);


    }
}