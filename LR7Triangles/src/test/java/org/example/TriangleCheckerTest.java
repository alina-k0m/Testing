package org.example;

import org.junit.Test;
import static org.junit.Assert.*;

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
        assertEquals("Разносторонний", TriangleChecker.determineTriangleType(2, 2, 3));
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
}
