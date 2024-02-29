import java.util.Scanner;
import java.util.Stack;

class InvalidPathException extends Exception {
    public InvalidPathException(String message) {
        super(message);
    }
}

public class AbsoluteFilePath {

    public String simplifyPath(String A) throws InvalidPathException {
        if (A == null || A.isEmpty()) {
            throw new InvalidPathException("Input path is empty or null.");
        }

        String[] directories = A.split("/");
        Stack<String> stack = new Stack<>();

        for (String dir : directories) {
            if (dir.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop(); // Move up one level
                }
            } else if (!dir.equals(".") && !dir.isEmpty()) {
                stack.push(dir); // Add directory to stack
            }
        }

        // Reconstruct simplified path
        StringBuilder simplifiedPath = new StringBuilder();
        for (String dir : stack) {
            simplifiedPath.append("/").append(dir);
        }

        // Handle edge case when the simplified path is empty
        if (simplifiedPath.isEmpty()) {
            return "/";
        }

        return simplifiedPath.toString();
    }

    public static void main(String[] args) {

        // Taking Path input
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Path String : ");
        String path = sc.nextLine();

        // Creating an object of AbsoluteFilePath class
        AbsoluteFilePath solution = new AbsoluteFilePath();

        try {
            // Calling the function with the help of class to return simplified path
            System.out.println(solution.simplifyPath(path));
        } catch (InvalidPathException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
