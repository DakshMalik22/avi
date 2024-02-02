package Day_6;

public class ques3 {
    public static void main(String[] args) {
        int[][] array2D = {{1,2,3,4,5} ,{6,7,8,9,10},
                {11,12,13,14,15}, {16,17,18,19,20},
                {21,22,23,24,25}
        };


        System.out.println();
        for (int i = 0; i < array2D.length; i++) {

            for (int j = 0; j < array2D[0].length-i; j++) {

                System.out.print(array2D[j][j+i]+" ");
            }

            System.out.println();
        }

    }
}
