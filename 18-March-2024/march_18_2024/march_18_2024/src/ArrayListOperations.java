import java.util.ArrayList;

public class ArrayListOperations {
    public static void main(String[] args) {
        ArrayList<String> colors = new ArrayList<>(5);
        // Insert data into the ArrayList
        colors.add("Red");
        colors.add("Green");
        colors.add("Blue");
        colors.add("White");
        colors.add("Black");

        // Iterate through the colors
        for (String color : colors) {
            System.out.println(color);
        }

        // Retrieve a specific element at index 0
        System.out.println("Element at index 0: " + colors.get(0));
        // Retrieve a specific element at index 2
        System.out.println("Element at index 2: " + colors.get(2));

        // Update an element at index 2 with "Yellow"
        colors.set(2, "Yellow");
        System.out.println("After replacing element at index 2 with Yellow:");
        for (String color : colors) {
            System.out.println(color);
        }

        // Remove the element at index 2
        colors.remove(2);
        System.out.println("After removing element at index 2:");
        for (String color : colors) {
            System.out.println(color);
        }

        // Search for an element in the list
        String searchElement = "Red";
        if (colors.contains(searchElement)) {
            System.out.println("Element found: " + searchElement);
        }

        // Increase the size of the list
        colors.add("Yellow");
        System.out.println("After adding Yellow, list size: " + colors.size());

        // Add another element to dynamically increase the size
        colors.add("Violet");
        System.out.println("After adding Violet, list size: " + colors.size());

        // Trim the list
        colors.trimToSize();
        System.out.println("Size after trimming: " + colors.size());
    }
}

