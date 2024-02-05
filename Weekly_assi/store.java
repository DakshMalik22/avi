package Weekly_assi;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;


public class store {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of students: ");
        int students = sc.nextInt();

        int[] javaMarks = new int[students];
        int[] pythonMarks = new int[students];
        int[] cMarks = new int[students];

        String[] names = new String[students];
        for(int i=0; i<names.length; i++){
            System.out.print("Enter the name of student "+(i+1)+": ");
            names[i] = sc.next();
        }

        for(int i=0; i<students; i++){
            System.out.println("Enter the marks for "+names[i]+": ");

            System.out.print("Java: ");
            javaMarks[i] = sc.nextInt();
            while(javaMarks[i]>100 || javaMarks[i]<0){
                System.out.println("Kindly enter the Java marks for "+names[i]+" between the range 0 to 100");
                javaMarks[i] = sc.nextInt();
            }

            System.out.print("Python: ");
            pythonMarks[i] = sc.nextInt();
            while(pythonMarks[i]>100 || pythonMarks[i]<0){
                System.out.println("Kindly enter the Python marks for "+names[i]+" between the range 0 to 100");
                pythonMarks[i] = sc.nextInt();
            }

            System.out.print("C: ");
            cMarks[i] = sc.nextInt();
            while(cMarks[i]>100 || cMarks[i]<0){
                System.out.println("Kindly enter the C marks for "+names[i]+" between the range 0 to 100");
                cMarks[i] = sc.nextInt();
            }
        }

        int[] avgMarks = new int[students];
        for(int i=0; i<students; i++){
            avgMarks[i] = (javaMarks[i]+pythonMarks[i]+cMarks[i])/students;
        }

        System.out.print("Enter the minimum threshold value: ");
        int min = sc.nextInt();
        System.out.print("Enter the maximum threshold value: ");
        int max = sc.nextInt();
        System.out.print("Enter the passing marks: ");
        int pass = sc.nextInt();

        ArrayList<Integer> aboveAvg = new ArrayList<>();
        ArrayList<Integer> Avg = new ArrayList<>();
        ArrayList<Integer> belowAvg = new ArrayList<>();

        for(int i:avgMarks){
            if(i>=max){
                aboveAvg.add(i);
            }
            else if(i>min && i<max){
                Avg.add(i);
            }
            else{
                belowAvg.add(i);
            }
        }

        ArrayList<String> failures = new ArrayList<>();
        for(int i=0; i<students; i++){
            if(javaMarks[i]<pass || pythonMarks[i]<pass || cMarks[i]<pass){
                failures.add(names[i]);
            }
        }

        int topper = Integer.MIN_VALUE;
        HashMap<Integer, String> map = new HashMap<>();
        for(int i=0; i<students; i++){
            if(avgMarks[i]>topper && !failures.contains(names[i])){
                topper = avgMarks[i];
            }
            map.put(avgMarks[i], names[i]);
        }

        ArrayList<Integer> toppers = new ArrayList<>();
        for(int n:avgMarks){
            if(!failures.contains(map.get(n)))
                toppers.add(n);
        }
        Collections.sort(toppers);
        Collections.reverse(toppers);

        System.out.print("The toppers are: ");
        for(int i=0; i<toppers.size(); i++){
            System.out.print(map.get(toppers.get(i))+" ");
        }

        System.out.println();
        for(int n:map.keySet()){
            if(n==topper){
                System.out.println("The overall topper is "+(map.get(n)));
            }
        }


        ArrayList<String> personalAttention = new ArrayList<>();

        for(int i=0; i<students; i++){
            if(avgMarks[i]<min || javaMarks[i]<pass || pythonMarks[i]<pass || cMarks[i]<pass){
                personalAttention.add(names[i]);

            }
        }

        System.out.print("Personal attention will be required for students: ");
        for(int i=0; i<personalAttention.size(); i++){
            System.out.print(personalAttention.get(i)+" ");
        }

    }
}
