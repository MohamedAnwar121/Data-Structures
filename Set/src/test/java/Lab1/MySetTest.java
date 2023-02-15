package Lab1;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MySetTest {

    // Test Universe = [ "s1" , "s2" , "s3" , "s4" , "s5" , "s6" , "s7" , "s8" , "s9"]

    MySet set = new MySet(new ArrayList<>(Arrays.asList("s1", "s2", "s3", "s4", "s5", "s6", "s7", "s8", "s9")));

    @Test
    void unionTest1() { //
        ArrayList<String> set1 = new ArrayList<>(Arrays.asList("s1", "s3", "s7"));
        ArrayList<String> set2 = new ArrayList<>(Arrays.asList("s3", "s5", "s6", "s7"));

        ArrayList<ArrayList<String>> sets = new ArrayList<>(Arrays.asList(set1, set2));
        set.setSets(sets);

        assertEquals(new ArrayList<>(Arrays.asList("s1", "s3", "s5", "s6", "s7")), set.Union(0, 1));
    }

    @Test
    void unionTest2() {
        ArrayList<String> set1 = new ArrayList<>(); //"s2","s3"
        ArrayList<String> set2 = new ArrayList<>(Arrays.asList("s1", "s8", "s2"));

        ArrayList<ArrayList<String>> sets = new ArrayList<>(Arrays.asList(set1, set2));
        set.setSets(sets);

        assertEquals(new ArrayList<>(Arrays.asList("s1", "s2", "s8")), set.Union(0, 1));
    }

    @Test
    void intersectionTest1() {
        ArrayList<String> set1 = new ArrayList<>(Arrays.asList("s1", "s3", "s7"));
        ArrayList<String> set2 = new ArrayList<>(Arrays.asList("s3", "s5", "s6", "s7"));

        ArrayList<ArrayList<String>> sets = new ArrayList<>(Arrays.asList(set1, set2));
        set.setSets(sets);

        assertEquals(new ArrayList<>(Arrays.asList("s3","s7")), set.Intersection(0, 1));
    }

    @Test
    void intersectionTest2() {
        ArrayList<String> set1 = new ArrayList<>(Arrays.asList("s2", "s5"));
        ArrayList<String> set2 = new ArrayList<>(Arrays.asList("s6", "s7"));

        ArrayList<ArrayList<String>> sets = new ArrayList<>(Arrays.asList(set1, set2));
        set.setSets(sets);

        assertEquals(new ArrayList<>(), set.Intersection(0, 1));
    }

    @Test
    void complementTest1() {
        ArrayList<String> set1 = new ArrayList<>(Arrays.asList("s1", "s3", "s7"));

        ArrayList<ArrayList<String>> sets = new ArrayList<>(List.of(set1));
        set.setSets(sets);

        assertEquals(new ArrayList<>(Arrays.asList("s2","s4","s5","s6","s8","s9")), set.Complement(0));
    }

    @Test
    void complementTest2() {
        ArrayList<String> set1 = new ArrayList<>(Arrays.asList("s5", "s6"));

        ArrayList<ArrayList<String>> sets = new ArrayList<>(List.of(set1));
        set.setSets(sets);

        assertEquals(new ArrayList<>(Arrays.asList("s1", "s2", "s3", "s4", "s7", "s8", "s9")), set.Complement(0));
    }
}