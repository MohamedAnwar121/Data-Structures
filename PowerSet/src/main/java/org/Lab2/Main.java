package org.Lab2;

import java.util.ArrayList;
import java.util.*;

public class Main {
    public static final Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        PowerSet powerSet = new PowerSet();

        System.out.println("Enter the size of the set: ");
        int n = input.nextInt();

        ArrayList<String> set = new ArrayList<>();
        System.out.println("Enter " + n + " Strings: ");
        for (int i = 0; i < n; i++) set.add(input.next());
        powerSet.setSet(set);

        first:
        do {
            System.out.println("For The Recursive Approach Enter 1");
            System.out.println("For The iterative Approach Enter 2");
            System.out.println("For Exit Enter 0");

            int choice = input.nextInt();

            switch (choice) {
                case 1:
                    powerSet.generateSubsetsRecursive(0);
                    powerSet.sortSubSets();
                    System.out.println(powerSet.getSubSets());
                    powerSet.getSubSets().clear();
                    break;
                case 2:
                    powerSet.generateSubsetsIterative();
                    powerSet.sortSubSets();
                    System.out.println(powerSet.getSubSets());
                    powerSet.getSubSets().clear();
                    break;
                case 0:
                    break first;
            }
        } while (true);
    }
}
