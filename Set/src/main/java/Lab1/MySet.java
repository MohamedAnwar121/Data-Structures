package Lab1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class MySet {

    HashMap<String, Integer> stringIndex;
    ArrayList<String> universe;
    ArrayList<ArrayList<String>> sets;
    BitOperations bits;

    public MySet() {
        sets = new ArrayList<>();
        stringIndex = new HashMap<>();
        bits = new BitOperations();
    }

    public MySet(ArrayList<String> universe) {
        this.universe = universe;
        Collections.sort(universe);

        sets = new ArrayList<>();
        stringIndex = new HashMap<>();
        bits = new BitOperations();

        for (int i = 0; i < universe.size(); i++) {
            stringIndex.put(universe.get(universe.size() - i - 1), i);
        }
    }

    public ArrayList<String> Union(int setOneIndex, int setTwoIndex) {
        ArrayList<String> set1 = sets.get(setOneIndex);
        ArrayList<String> set2 = sets.get(setTwoIndex);

        int set1Int = setToInt(set1);
        int set2Int = setToInt(set2);

        int resultInt = set1Int | set2Int;

        return intToSet(resultInt);
    }

    public ArrayList<String> Intersection(int setOneIndex, int setTwoIndex) {
        ArrayList<String> set1 = sets.get(setOneIndex);
        ArrayList<String> set2 = sets.get(setTwoIndex);

        int set1Int = setToInt(set1);
        int set2Int = setToInt(set2);

        int resultInt = set1Int & set2Int;

        return intToSet(resultInt);
    }

    public ArrayList<String> Complement(int setIndex) {
        ArrayList<String> set = sets.get(setIndex);

        int setInt = setToInt(set);

        int resultInt = ~setInt;

        return intToSet(resultInt);
    }

    private int setToInt(ArrayList<String> set) {

        int result = 0;

        for (String s : set) {
            int index = stringIndex.get(s);
            result = bits.setBit(result, index);
        }

        return result;
    }

    private ArrayList<String> intToSet(int setInt) {

        ArrayList<String> set = new ArrayList<>();

        for (int i = 0; i < universe.size(); i++) {
            if (bits.getBit(setInt, universe.size() - i - 1) == 1) {
                set.add(universe.get(i));
            }
        }

        return set;
    }

    public ArrayList<String> getUniverse() {
        return universe;
    }

    public void setUniverse(ArrayList<String> universe) {
        this.universe = universe;

        for (int i = 0; i < universe.size(); i++) {
            stringIndex.put(universe.get(universe.size() - i - 1), i);
        }
    }

    public ArrayList<ArrayList<String>> getSets() {
        return sets;
    }

    public void setSets(ArrayList<ArrayList<String>> sets) {
        this.sets = sets;
    }
}
