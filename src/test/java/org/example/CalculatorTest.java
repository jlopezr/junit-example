package org.example;

import org.junit.Test;
import static org.junit.Assert.*;

public class CalculatorTest {
    Calculator calculator =new Calculator();
    @Test
    public void add(){
        assertEquals(8,calculator.add(5, 3));
    }
    @Test
    public void subtract(){
        assertEquals(2,calculator.subtract(5,3));
    }
    @Test
    public void multiply(){
        assertEquals(15, calculator.multiply(5,3));
    }
    @Test
    public void divide(){
        assertEquals(1,calculator.divide(5,3));
    }
    @Test(expected =IllegalArgumentException.class)
    public void divideByZero() {
        calculator.divide(5,0);
    }

    @Test
    public void testCompare() {
        assertEquals("5 is greater than 3", calculator.compare(5, 3));
    }

    @Test
    public void testCompareEqual() {
        assertEquals("5 is equal to 5", calculator.compare(5, 5));
    }

    @Test
    public void testCompareLess() {
        assertEquals("3 is less than 5", calculator.compare(3, 5));
    }
}