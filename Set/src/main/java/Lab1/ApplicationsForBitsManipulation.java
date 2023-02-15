package Lab1;

import java.util.ArrayList;

// Part 3

public class ApplicationsForBitsManipulation {

    private final BitOperations bits = new BitOperations();

    // Problem 1
    public long getSingleOccurrence(ArrayList<Integer> array){
        long result = 0;
        for (Integer element : array) {
            result = result ^ element;
        }
        return result;
    }

    // Problem 2
    public int countOnes(int number){
        int count = 0;
        while (number != 0){
            count += bits.getBit(number,0);
            number >>= 1;
        }
        return count;
    }

}
