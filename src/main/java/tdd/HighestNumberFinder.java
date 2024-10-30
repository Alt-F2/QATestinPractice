package tdd;

import java.util.Arrays;
import java.util.Collections;

public class HighestNumberFinder {
    public int findHighestNumber(int[] input) {
        int highestSoFar = 0;

        if(input.length == 1){
            return input[0];
        }

        for(int i = 0; i < input.length; i++){
            if(input[i] > highestSoFar)
                highestSoFar = input[i];
        }

        return highestSoFar;
    }
}
