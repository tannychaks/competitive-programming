package general;

import java.util.*;
import java.util.stream.Collectors;


class Placement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cse = 0, ece = 0, mech = 0;
        
        System.out.print("Enter the no of students placed in CSE:");
        if(sc.hasNextInt())
            cse = sc.nextInt();
        System.out.println();
        System.out.print("Enter the no of students placed in ECE:");
        if(sc.hasNextInt())
            ece = sc.nextInt();
        System.out.println();
        System.out.print("Enter the no of students placed in MECH");
        if(sc.hasNextInt())
            mech = sc.nextInt();
        System.out.println();
        
        List<Integer> list = new TreeSet<>(Arrays.asList(cse, ece, mech)).stream().collect(Collectors.toList());
        
        if (list.get(0) < 0) {
            System.out.println("Input is Invalid");
        } else if (list.size() == 1) {
            System.out.println("None of the department has got the highest placement");
        } else {
            System.out.println("Highest placement");
            
            int highest = list.get(list.size() - 1);
            
            if (list.size() == 2) {
                if (cse == highest && ece == highest) {
                    System.out.println("CSE");
                    System.out.println("ECE");
                } else if (cse == highest && mech == highest) {
                    System.out.println("CSE");
                    System.out.println("MECH");
                } else if (ece == highest && mech == highest) {
                    System.out.println("ECE");
                    System.out.println("MECH");
                } else if (cse == highest) {
                    System.out.println("CSE");
                } else if (ece == highest) {
                    System.out.println("ECE");
                } else if (mech == highest) {
                    System.out.println("MECH");
                }
            } else {
                if (cse == highest) {
                    System.out.println("CSE");
                } else if (ece == highest) {
                    System.out.println("ECE");
                } else if (mech == highest) {
                    System.out.println("MECH");
                }
            }
        }
        sc.close();
    }
}