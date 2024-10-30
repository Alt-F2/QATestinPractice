package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ItemTest
{
    @Test
    void getTotal_Price()
    {
        // arrange
        Item cut = new Item("Banana", 6, 0.19);
        double expectedResult = 1.14;

        // act
        double actualResult = cut.retrieveTotalPrice();

        // assert
        assertEquals(expectedResult, actualResult, 2);
    }
}
