package Day_7.recursion;

import java.util.Scanner;

public class ques8 {
  public static void towerOfHanoi(int n, char from_rod, char to_rod, char aux_rod) {
      // Base case: If there is only one disk, move it directly from from_rod to to_rod 
      if (n == 1) {
            System.out.println("Move disk 1 from rod " + from_rod + " to rod " + to_rod);
            return;
        }
       // Recursive step:
        // Move n-1 disks from from_rod to aux_rod using to_rod as the auxiliary rod
        towerOfHanoi(n - 1, from_rod, aux_rod, to_rod);
     
      // Move the remaining disk (disk n) from from_rod to to_rod
      System.out.println("Move disk " + n + " from rod " + from_rod + " to rod " + to_rod);
    
      // Recursive step:
        // Move the n-1 disks from aux_rod to to_rod using from_rod as the auxiliary rod
       towerOfHanoi(n - 1, aux_rod, to_rod, from_rod);
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
     
        towerOfHanoi(n, 'A', 'C', 'B');
    }
}
