package tdd;

import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class HighestNumberFinderTest {
    @Test
    public void find_highest_in_array_of_one_expect_single_item(){
        // arrange
        int[] input = {10};
        HighestNumberFinder cut = new HighestNumberFinder();
        int expectedResult = 10;

        // act
        int actualResult = cut.findHighestNumber(input);

        // assert
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void find_highest_number_in_an_array_of_two_descending_expect_first_element(){
        // arrange
        int[] input = {13, 7};
        HighestNumberFinder cut = new HighestNumberFinder();
        int expectedResult = 13;

        // act
        int actualResult = cut.findHighestNumber(input);

        // assert
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void find_highest_number_in_an_array_of_two_ascending_expect_second_element(){
        // arrange
        int[] input = {7, 13};
        HighestNumberFinder cut = new HighestNumberFinder();
        int expectedResult = 13;

        // act
        int actualResult = cut.findHighestNumber(input);

        // assert
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void find_highest_number_in_an_array_of_x_ascending_expect_x_element(){
        // arrange
        int[] input = {4, 5, -8, 3, 11, -21, 6};
        HighestNumberFinder cut = new HighestNumberFinder();
        int expectedResult = 11;

        // act
        int actualResult = cut.findHighestNumber(input);

        // assert
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void verify_empty_array_throws_exception(){
        // arrange
        int[] input = {};
        HighestNumberFinder cut = new HighestNumberFinder();
        NoSuchElementException exception = assertThrows(NoSuchElementException.class,
                                                    () -> cut.findHighestNumber(input));

        // assert
        assertEquals("Empty array list", exception.getMessage());
    }

    @Test
    public void verify_only_one_element_of_array_with_multiple_equal_and_highest_is_returned(){
        // arrange
        int[] input = {6, 6, 6, 6, 6, 6, 6};
        HighestNumberFinder cut = new HighestNumberFinder();
        int expectedResult = 6;

        // act
        int actualResult = cut.findHighestNumber(input);

        // assert
        assertEquals(expectedResult, actualResult);
    }
}
