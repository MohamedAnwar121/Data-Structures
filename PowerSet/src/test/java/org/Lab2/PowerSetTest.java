package org.Lab2;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PowerSetTest {

    PowerSet set = new PowerSet();
    ArrayList<ArrayList<String>> subSets;

    @Test
    void generateSubsetsRecursiveTest1() { // set = {"1","2","3"}
        subSets = new ArrayList<>();
        subSets.add(new ArrayList<>());
        subSets.add(new ArrayList<>(List.of("1")));
        subSets.add(new ArrayList<>(List.of("2")));
        subSets.add(new ArrayList<>(List.of("3")));
        subSets.add(new ArrayList<>(List.of("1","2")));
        subSets.add(new ArrayList<>(List.of("1","3")));
        subSets.add(new ArrayList<>(List.of("2","3")));
        subSets.add(new ArrayList<>(List.of("1","2","3")));
        this.sortSubSets();

        set = new PowerSet(new ArrayList<>(List.of("1","2","3")));
        set.generateSubsetsRecursive(0);
        set.sortSubSets();
        assertEquals(subSets,set.getSubSets());
    }

    @Test
    void generateSubsetsRecursiveTest2() { // set = {"s1","s2","s3","s4"}
        subSets = new ArrayList<>();
        subSets.add(new ArrayList<>());
        subSets.add(new ArrayList<>(List.of("s1")));
        subSets.add(new ArrayList<>(List.of("s2")));
        subSets.add(new ArrayList<>(List.of("s3")));
        subSets.add(new ArrayList<>(List.of("s4")));
        subSets.add(new ArrayList<>(List.of("s1","s2")));
        subSets.add(new ArrayList<>(List.of("s1","s3")));
        subSets.add(new ArrayList<>(List.of("s1","s4")));
        subSets.add(new ArrayList<>(List.of("s2","s3")));
        subSets.add(new ArrayList<>(List.of("s2","s4")));
        subSets.add(new ArrayList<>(List.of("s3","s4")));
        subSets.add(new ArrayList<>(List.of("s1","s2","s3")));
        subSets.add(new ArrayList<>(List.of("s1","s2","s4")));
        subSets.add(new ArrayList<>(List.of("s2","s3","s4")));
        subSets.add(new ArrayList<>(List.of("s1","s3","s4")));
        subSets.add(new ArrayList<>(List.of("s1","s2","s3","s4")));
        this.sortSubSets();

        set = new PowerSet(new ArrayList<>(List.of("s1","s2","s3","s4")));
        set.generateSubsetsRecursive(0);
        set.sortSubSets();
        assertEquals(subSets,set.getSubSets());
    }

    @Test
    void generateSubsetsIterativeTest1() {
        subSets = new ArrayList<>();
        subSets.add(new ArrayList<>());
        subSets.add(new ArrayList<>(List.of("1")));
        subSets.add(new ArrayList<>(List.of("2")));
        subSets.add(new ArrayList<>(List.of("3")));
        subSets.add(new ArrayList<>(List.of("1","2")));
        subSets.add(new ArrayList<>(List.of("1","3")));
        subSets.add(new ArrayList<>(List.of("2","3")));
        subSets.add(new ArrayList<>(List.of("1","2","3")));
        this.sortSubSets();

        set = new PowerSet(new ArrayList<>(List.of("1","2","3")));
        set.generateSubsetsIterative();
        set.sortSubSets();
        assertEquals(subSets,set.getSubSets());
    }

    @Test
    void generateSubsetsIterativeTest2() {
        subSets = new ArrayList<>();
        subSets.add(new ArrayList<>());
        subSets.add(new ArrayList<>(List.of("s1")));
        subSets.add(new ArrayList<>(List.of("s2")));
        subSets.add(new ArrayList<>(List.of("s3")));
        subSets.add(new ArrayList<>(List.of("s4")));
        subSets.add(new ArrayList<>(List.of("s1","s2")));
        subSets.add(new ArrayList<>(List.of("s1","s3")));
        subSets.add(new ArrayList<>(List.of("s1","s4")));
        subSets.add(new ArrayList<>(List.of("s2","s3")));
        subSets.add(new ArrayList<>(List.of("s2","s4")));
        subSets.add(new ArrayList<>(List.of("s3","s4")));
        subSets.add(new ArrayList<>(List.of("s1","s2","s3")));
        subSets.add(new ArrayList<>(List.of("s1","s2","s4")));
        subSets.add(new ArrayList<>(List.of("s2","s3","s4")));
        subSets.add(new ArrayList<>(List.of("s1","s3","s4")));
        subSets.add(new ArrayList<>(List.of("s1","s2","s3","s4")));
        this.sortSubSets();

        set = new PowerSet(new ArrayList<>(List.of("s1","s2","s3","s4")));
        set.generateSubsetsIterative();
        set.sortSubSets();
        assertEquals(subSets,set.getSubSets());
    }

    public void sortSubSets() {
        ArrayList<String> newSubSet = new ArrayList<>();

        for (ArrayList<String> subSet : subSets) {
            StringBuilder temp = new StringBuilder();
            for (String s : subSet) {
                temp.append(s).append(" ");
            }
            newSubSet.add(temp.toString());
        }

        Collections.sort(newSubSet);

        subSets.clear();
        for (String s : newSubSet) {
            ArrayList<String> tempArray = new ArrayList<>();
            StringBuilder temp = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) != ' ') {
                    temp.append(s.charAt(i));
                } else if (temp.length() > 0) {
                    tempArray.add(temp.toString());
                    temp = new StringBuilder();
                }
            }
            subSets.add(new ArrayList<>(tempArray));
        }

        if (!subSets.get(0).isEmpty()) subSets.add(0,new ArrayList<>());
    }

}