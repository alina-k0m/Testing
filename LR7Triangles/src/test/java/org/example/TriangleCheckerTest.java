package org.example;

import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.Assert.*;

//Доменное тестирование: https://docs.google.com/spreadsheets/d/1-PzAt-1ALu5oMpRiPYCEuQI3Nm7WUggFIsQPgwLSL7s/edit#gid=1708739383

public class TriangleCheckerTest {

    @Test
    public void testInvalidTriangles() {
        assertEquals("Некорректный", TriangleChecker.determineTriangleType(0, 0, 0));
        assertEquals("Некорректный", TriangleChecker.determineTriangleType(0, 1, 1));
        assertEquals("Некорректный", TriangleChecker.determineTriangleType(0, 5, 7));
    }

    @Test
    public void testBorderlineTriangles() {
        assertEquals("Некорректный", TriangleChecker.determineTriangleType(1, 1, 2));
        assertEquals("Равнобедренный", TriangleChecker.determineTriangleType(2, 2, 3));
    }

    @Test
    public void testScaleneTriangles() {
        assertEquals("Разносторонний", TriangleChecker.determineTriangleType(3, 4, 5));
        assertEquals("Разносторонний", TriangleChecker.determineTriangleType(5, 6, 7));
    }

    @Test
    public void testIsoscelesTriangles() {
        assertEquals("Равнобедренный", TriangleChecker.determineTriangleType(3, 3, 4));
        assertEquals("Равнобедренный", TriangleChecker.determineTriangleType(5, 5, 8));
    }

    @Test
    public void testEquilateralTriangles() {
        assertEquals("Равносторонний", TriangleChecker.determineTriangleType(3, 3, 3));
        assertEquals("Равносторонний", TriangleChecker.determineTriangleType(5, 5, 5));
    }


    //параметризованный тест
    @ParameterizedTest
    @CsvSource({
            "0, 0, 0, Некорректный",
            "0, 1, 1, Некорректный",
            "0, 5, 7, Некорректный",
            "2, 2, 3, Равнобедренный",
            "3, 4, 5, Разносторонний",
            "5, 5, 5, Равносторонний",
    })

    public void testCheckTriangle(int a, int b, int c, String expectedResult) {
        assertEquals(expectedResult, TriangleChecker.determineTriangleType(a, b, c));
    }
}
