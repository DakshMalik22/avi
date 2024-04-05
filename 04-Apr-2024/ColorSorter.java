import java.util.Arrays;

public class ColorSorter {
    public int[] sortColors(int[] colors) {
        int low = 0;
        int high = colors.length - 1;
        int mid = 0;
        
        while (mid <= high) {
            switch(colors[mid]) {
                case 0:
                    swap(colors, low, mid);
                    low++;
                    mid++;
                    break;
                case 1:
                    mid++;
                    break;
                case 2:
                    swap(colors, mid, high);
                    high--;
                    break;
            }
        }
        
        return colors;
    }
    
    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
    public static void main(String[] args) {
        ColorSorter sorter = new ColorSorter();
        
        // Example usage:
        int[] colors1 = {0, 1, 2, 0, 1, 2};
        int[] sortedColors1 = sorter.sortColors(colors1);
        System.out.println(Arrays.toString(sortedColors1)); // Output: [0, 0, 1, 1, 2, 2]
        
        int[] colors2 = {0};
        int[] sortedColors2 = sorter.sortColors(colors2);
        System.out.println(Arrays.toString(sortedColors2)); // Output: [0]
    }
}
