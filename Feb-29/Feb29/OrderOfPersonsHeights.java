package Feb29;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

class OrderOfPersonsHeightsException extends Exception {
    public OrderOfPersonsHeightsException(String message) {
        super(message);
    }
}

class OrderOfPersonsHeights {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter the size of heights array:");
            int size = scanner.nextInt();
            if (size <= 0) {
                throw new OrderOfPersonsHeightsException("Size of heights array must be greater than zero.");
            }
            int[] heights = new int[size];
            int[] infronts = new int[size];
            System.out.println("Enter heights array elements:");
            for (int heightsIndex = 0; heightsIndex < size; heightsIndex++)
                heights[heightsIndex] = scanner.nextInt();
            System.out.println("Enter infronts array elements:");
            for (int infrontsIndex = 0; infrontsIndex < infronts.length; infrontsIndex++)
                infronts[infrontsIndex] = scanner.nextInt();

            ArrayList<Integer> orderedPeople = orderPeople(heights, infronts);
            for (int i = 0; i < orderedPeople.size(); i++)
                System.out.println(orderedPeople.get(i).toString());
        } catch (OrderOfPersonsHeightsException e) {
            System.out.println("OrderOfPersonsHeightsException occurred: " + e.getMessage());
        }
    }

    public static ArrayList<Integer> orderPeople(int[] heights, int[] infronts) throws OrderOfPersonsHeightsException {
        if (heights == null || infronts == null || heights.length != infronts.length) {
            throw new OrderOfPersonsHeightsException("Invalid input: heights and infronts arrays must be non-null and of equal length.");
        }
        int n = heights.length;

        // Create pairs of heights and infronts
        int[][] people = new int[n][2];
        for (int i = 0; i < n; i++) {
            people[i][0] = heights[i];
            people[i][1] = infronts[i];
        }

        // Sort the pairs based on heights and infronts
        Arrays.sort(people, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                if (a[0] != b[0]) {
                    return Integer.compare(b[0], a[0]); // Sort heights in descending order
                } else {
                    return Integer.compare(a[1], b[1]); // Sort infronts in ascending order
                }
            }
        });

        // Insert each person into the result list at the specified position
        ArrayList<Integer> result = new ArrayList<>();
        for (int[] person : people) {
            result.add(person[1], person[0]);
        }

        return result;
    }
}


