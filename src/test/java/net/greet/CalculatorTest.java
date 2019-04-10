package net.greet;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

public class CalculatorTest {
    //add, sub, multipl, division
    @Test
    public void subTwoNumbers() {
        Calculator calculator = new Calculator();

        assertEquals(calculator.sub(4, 3), 1);
    }

    @Test
    public void multiplyTwoNumbers() {
        Calculator calculator = new Calculator();

        assertEquals(calculator.mult(4, 3), 12);
    }

    @Test
    public void divisionTwoNumbers() {
        Calculator calculator = new Calculator();

        assertEquals(calculator.div(4, 2), 2);
    }

    @Test
    public void addTwoNumbers() {
        Calculator calculator = new Calculator();

        assertEquals(calculator.add(4, 3), 7);
    }
}
