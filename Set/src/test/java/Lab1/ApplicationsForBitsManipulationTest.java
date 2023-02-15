package Lab1;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class ApplicationsForBitsManipulationTest {

    ApplicationsForBitsManipulation testObject = new ApplicationsForBitsManipulation();

    @Test
    void getSingleOccurrenceTest1(){ // Array = [2 , 5 , 6 , 5 , 3 , 2 , 6] -> returns 3
        ArrayList<Integer> Array = new ArrayList<>(Arrays.asList(2, 5, 6, 5, 3, 2, 6));
        assertEquals(3,testObject.getSingleOccurrence(Array));
    }

    @Test
    void getSingleOccurrenceTest2(){ // Array = [2010 , 1 , 50 , 60 , 2010 , 3 , 1 , 50 , 3] -> returns 60
        ArrayList<Integer> Array = new ArrayList<>(Arrays.asList(2010 , 1 , 50 , 60 , 2010 , 3 , 1 , 50 , 3));
        assertEquals(60,testObject.getSingleOccurrence(Array));
    }

    @Test
    void countOnesTest1(){ // count ones in 61074 -> returns 9
        assertEquals(9,testObject.countOnes(61074));
    }

    @Test
    void countOnesTest2(){ // count ones in 2562 -> returns 3
        assertEquals(3,testObject.countOnes(2562));
    }

}