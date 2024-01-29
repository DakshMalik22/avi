package set3;

import java.util.HashMap;
import java.util.Scanner;

public class ques3 {
    public static void main(String[] args) {
        int[] arr = {1,1,1,2,3,3,3,2,4,4};
        Scanner use = new Scanner(System.in);
        HashMap<Integer,Integer>myMap = new HashMap<>();

        for(int num:arr){
            if(myMap.containsKey(num)){
                myMap.put(num, myMap.get(num)+1);
            }
            else{
                myMap.put(num, 1);
            }
        }
        for(Integer n: myMap.keySet()){
            if(myMap.get(n)>=3){
                continue;
            }
            else{
                System.out.print(n);
            }
        }
    }
}
