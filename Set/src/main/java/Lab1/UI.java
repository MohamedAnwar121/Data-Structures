package Lab1;

import java.util.ArrayList;
import java.util.Scanner;

public class UI {
    private static final Scanner scan = new Scanner(System.in);

    public UI() {

        System.out.println("1- Part 1");
        System.out.println("2- Part 2");
        System.out.println("3- Part 3");
        System.out.println("4- Exit Program ");
        System.out.print("Choose A Part :");


        int choice = scan.nextInt();
        System.out.println("------------------------------------------------");
        switch (choice) {
            case 1 -> UIForPart1();
            case 2 -> UIForPart2();
            case 3 -> UIForPart3();
            case 4 -> System.exit(0);
        }
    }

    public static void UIForPart1() {

        BitOperations bits = new BitOperations();

        while(true){
            System.out.println("1- getBit");
            System.out.println("2- setBit");
            System.out.println("3- clearBit");
            System.out.println("4- updateBit");
            System.out.println("5- back to main menu");
            System.out.print("Choose an operation :");
            int operation = scan.nextInt();

            switch (operation) {
                case 1:
                    System.out.println("---------------------------------");
                    System.out.println("Enter a number and the position of the bit :");
                    int number = scan.nextInt();
                    int pos = scan.nextInt();

                    System.out.printf("bit number %d = %d\n", pos, bits.getBit(number, pos - 1));
                    break;
                case 2:
                    System.out.println("---------------------------------");
                    System.out.println("Enter a number and the position of the bit :");
                    number = scan.nextInt();
                    pos = scan.nextInt();

                    System.out.printf("Number after setting bit number %d = %d\n", pos, bits.setBit(number, pos - 1));
                    break;
                case 3:
                    System.out.println("---------------------------------");
                    System.out.println("Enter a number and the position of the bit :");
                    number = scan.nextInt();
                    pos = scan.nextInt();

                    System.out.printf("Number after clearing bit number %d = %d\n", pos, bits.clearBit(number, pos - 1));
                    break;
                case 4:
                    System.out.println("---------------------------------");
                    System.out.println("Enter a number and the position of the bit and the new value (0,1) :");
                    number = scan.nextInt();
                    pos = scan.nextInt();
                    int value = scan.nextInt();

                    System.out.printf("Number after updating bit number %d = %d\n", pos, bits.updateBit(number, pos - 1, value != 0));
                    break;
                case 5:
                    System.out.println("------------------------------------------------");
                    new UI();
                    break;
                default:
                    System.out.println("Error , Enter a Valid Input");
            }
            System.out.println("------------------------------------------------");
        }
    }

    public static void UIForPart2() {
        System.out.print("Please enter your universe size :");
        int universeSize = scan.nextInt();

        System.out.println("------------------------------------------------");
        System.out.printf("Please enter your universe (%d Strings) : \n", universeSize);

        ArrayList<String> universe = new ArrayList<>();
        for (int i = 0; i < universeSize; i++) {
            String element = scan.next();
            universe.add(element);
        }

        MySet set = new MySet(universe);

        System.out.println("------------------------------------------------");
        System.out.print("Please enter number of sets :");

        int setsSize = scan.nextInt();
        System.out.printf("Please enter your sets (%d Sets) : \n", setsSize);
        System.out.println("---------------------------------");

        ArrayList<ArrayList<String>> sets = new ArrayList<>();
        for (int i = 0; i < setsSize; i++) {
            System.out.printf("Please enter set %d size :", i + 1);
            int setSize = scan.nextInt();
            System.out.println("------------------------------------------------");
            ArrayList<String> setI = new ArrayList<>();

            if (setSize != 0) System.out.printf("Please enter set (%d Strings) :\n", setSize);
            for (int j = 0; j < setSize; j++) {
                String s = scan.next();
                setI.add(s);
            }
            sets.add(setI);
        }

        set.setSets(sets);

        while (true) {
            System.out.println("------------------------------------------------");

            System.out.print("Universe = ");
            System.out.println(set.getUniverse());
            for (int i = 0; i < set.getSets().size(); i++) {
                System.out.printf("Set %d = ", i + 1);
                System.out.println(set.getSets().get(i));
            }

            System.out.println();
            System.out.println("Operations");
            System.out.println("1- Union");
            System.out.println("2- Intersection");
            System.out.println("3- Complement");
            System.out.println("4- Back to main menu");
            System.out.print("Choose an Operation : ");

            int operation = scan.nextInt();
            switch (operation) {
                case 1:
                    System.out.println("Enter 2 Indexes :");
                    int index1 = scan.nextInt();
                    int index2 = scan.nextInt();
                    System.out.println(set.Union(index1 - 1, index2 - 1));
                    break;
                case 2:
                    System.out.println("Enter 2 Indexes :");
                    index1 = scan.nextInt();
                    index2 = scan.nextInt();
                    System.out.println(set.Intersection(index1 - 1, index2 - 1));
                    break;
                case 3:
                    System.out.println("Enter an Index :");
                    int index = scan.nextInt();
                    System.out.println(set.Complement(index - 1));
                    break;
                case 4:
                    System.out.println("------------------------------------------------");
                    new UI();
                    break;
                default:
                    System.out.println("Error , Enter a Valid Input");
            }
        }
    }

    public static void UIForPart3() {
        first:
        do {
            System.out.println("Operations");
            System.out.println("1- To get the unrepeated number of an array");
            System.out.println("2- To get the number of ones in a number");
            System.out.println("3- Back to main menu");
            System.out.print("Choose an operation :");
            int x = scan.nextInt();
            System.out.println("------------------------------------------------");
            ApplicationsForBitsManipulation a = new ApplicationsForBitsManipulation();
            switch (x) {
                case 1:
                    System.out.println("Enter the size of the array :");
                    int size = scan.nextInt();
                    ArrayList<Integer> array = new ArrayList<>();
                    for (int i = 0; i < size; i++) {
                        System.out.print("Enter element number " + (i + 1) + " : ");
                        array.add(scan.nextInt());
                    }
                    System.out.println("The non repeated number is : " + a.getSingleOccurrence(array));
                    System.out.println("------------------------------------------------");
                    break;
                case 2:
                    System.out.print("Enter the number : ");
                    int z = scan.nextInt();
                    System.out.println("The number of ones is : " + a.countOnes(z));
                    System.out.println("------------------------------------------------");
                    break;
                case 3:
                    new UI();
                    return;
                default:
                    break first;
            }
        } while (true);
    }
}
