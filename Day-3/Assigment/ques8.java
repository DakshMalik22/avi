package Assigment;

public class ques8 {
    public static void main(String[] args) {
        int[] arr1 ={3, 5, 9};
        int[] arr2 ={1, 2, 3, 8};
        int size = arr1.length+ arr2.length;
        int[] ans = new int[size];
        int k=0;
        int i=0;
        int j=0;

        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] <= arr2[j]) {
                ans[k++] = arr1[i++];
            } else {
                ans[k++] = arr2[j++];
            }
        }

        // Copy remaining elements from arr1, if any
        while (i < arr1.length) {
            ans[k++] = arr1[i++];
        }

        // Copy remaining elements from arr2, if any
        while (j < arr2.length) {
            ans[k++] = arr2[j++];
        }

        // Print the merged and sorted array
        for (int num : ans) {
            System.out.print(num + " ");
        }

    }
}
