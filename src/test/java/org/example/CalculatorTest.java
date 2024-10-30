package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTest {
    @Test
    public void onAddition_verify_values_are_added_correctly(){
        // arrange
        Calculator cut = new Calculator();
        float expectedResult = 20.00f;

        // act
        cut.add(20.00f);
        float actualResult = cut.getTotal();

        // assert
        assertEquals(expectedResult, actualResult);
    }
    @Test
    public void onSubtraction_verify_values_are_subtracted_correctly(){
        // arrange
        Calculator cut = new Calculator();
        float expectedResult = -20.00f;

        // act
        cut.subtract(20.00f);
        float actualResult = cut.getTotal();

        // assert
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void onMultiplication_verify_values_are_multiplied_correctly(){
        // arrange
        Calculator cut = new Calculator();
        cut.add(10.00f);
        float expectedResult = 200.00f;

        // act
        cut.multiply(20.00f);
        float actualResult = cut.getTotal();

        // assert
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void onDivide_verify_values_are_divided_correctly(){
        // arrange
        Calculator cut = new Calculator();
        cut.add(10.00f);
        float expectedResult = 5.00f;

        // act
        cut.divide(2.00f);
        float actualResult = cut.getTotal();

        // assert
        assertEquals(expectedResult, actualResult);
    }


}
