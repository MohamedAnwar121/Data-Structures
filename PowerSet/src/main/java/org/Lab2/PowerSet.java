package org.Lab2;

import java.util.ArrayList;
import java.util.Collections;


public class PowerSet implements IPowerSet{

    private ArrayList<String> set;
    private final ArrayList<String> tempSet;
    private ArrayList<ArrayList<String>> subSets;

    public PowerSet(ArrayList<String> set) {
        this.set = set;
        tempSet = new ArrayList<>();
        subSets = new ArrayList<>();
    }

    public PowerSet() {
        tempSet = new ArrayList<>();
        subSets = new ArrayList<>();
    }

    public void generateSubsetsRecursive(int index) {
        if (index == set.size()) {
            subSets.add(new ArrayList<>(tempSet));
            return;
        }

        generateSubsetsRecursive(index + 1);

        tempSet.add(set.get(index));
        generateSubsetsRecursive(index + 1);
        tempSet.remove(tempSet.size() - 1);
    }

    public void generateSubsetsIterative() {
        int n = 1 << set.size();
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < set.size(); ++j) {
                if (((i & (1 << j)) >> j) == 1) {
                    tempSet.add(set.get(j));
                }
            }
            subSets.add(new ArrayList<>(tempSet));
            tempSet.clear();
        }
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

    public ArrayList<String> getSet() {
        return set;
    }

    public void setSet(ArrayList<String> set) {
        this.set = set;
    }

    public ArrayList<ArrayList<String>> getSubSets() {
        return subSets;
    }

    public void setSubSets(ArrayList<ArrayList<String>> subSets) {
        this.subSets = subSets;
    }
}
