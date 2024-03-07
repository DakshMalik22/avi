package March6;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class TreeNode {
    int value;
    TreeNode left;
    TreeNode right;

    TreeNode() {}

    TreeNode(int value) {
        this.value = value;
    }

    TreeNode(int value, TreeNode left, TreeNode right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }
}

// Custom exception class for tree-related errors
class TreeOperationException extends Exception {
    public TreeOperationException(String message) {
        super(message);
    }
}

public class BurnBinaryTree {
    // Function to search for a target node and print the sequence of burning nodes
    public static int searchAndPrintBurningSequence(TreeNode root, int targetNodeValue, Map<Integer, Set<Integer>> levelOrderMap) throws TreeOperationException {
        if (root != null) {
            // Check if the target node is found
            if (root.value == targetNodeValue) {
                // Store the level order for the left and right subtrees
                storeLevelOrder(root.left, 1, levelOrderMap);
                storeLevelOrder(root.right, 1, levelOrderMap);
                // Return to prevent further function calls
                return 1;
            }
            int targetNodeLevel = searchAndPrintBurningSequence(root.left, targetNodeValue, levelOrderMap);
            if (targetNodeLevel > 0) {
                // Store the root in the map with the level
                storeRootAtLevel(root, targetNodeLevel, levelOrderMap);
                // Store the level order for the other branch
                storeLevelOrder(root.right, targetNodeLevel + 1, levelOrderMap);
                return targetNodeLevel + 1;
            }
            targetNodeLevel = searchAndPrintBurningSequence(root.right, targetNodeValue, levelOrderMap);
            if (targetNodeLevel > 0) {
                // Store the root in the map with the level
                storeRootAtLevel(root, targetNodeLevel, levelOrderMap);
                // Store the level order for the other branch
                storeLevelOrder(root.left, targetNodeLevel + 1, levelOrderMap);
                return targetNodeLevel + 1;
            }
        }
        return -1; // Base condition
    }

    // Function to store the level order of nodes in the tree
    public static void storeLevelOrder(TreeNode root, int level, Map<Integer, Set<Integer>> levelOrderMap) {
        if (root != null) {
            storeRootAtLevel(root, level, levelOrderMap);
            storeLevelOrder(root.left, level + 1, levelOrderMap);
            storeLevelOrder(root.right, level + 1, levelOrderMap);
        }
    }

    // Function to store the root node at the specified level in the map
    private static void storeRootAtLevel(TreeNode root, int level, Map<Integer, Set<Integer>> levelOrderMap) {
        if (levelOrderMap.containsKey(level)) {
            levelOrderMap.get(level).add(root.value);
        } else {
            Set<Integer> set = new HashSet<>();
            set.add(root.value);
            levelOrderMap.put(level, set);
        }
    }

    // Driver Code
    public static void main(String[] args) {
        // Create a binary tree
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(13);
        root.right = new TreeNode(10);
        root.right.left = new TreeNode(14);
        root.right.right = new TreeNode(15);
        TreeNode left = root.right.left;
        TreeNode right = root.right.right;
        left.left = new TreeNode(21);
        left.right = new TreeNode(24);
        right.left = new TreeNode(22);
        right.right = new TreeNode(23);

        // Create a map to store the level order of nodes
        Map<Integer, Set<Integer>> levelOrderMap = new HashMap<>();

        try {
            // Search for the target node (14) and store its level order in the map
            int targetNodeLevel = searchAndPrintBurningSequence(root, 14, levelOrderMap);

            // Print the target node and its burning sequence
            System.out.println("Target Node: 14");
            System.out.println("Burning Sequence:");
            for (int level = 1; level <= targetNodeLevel; level++) {
                System.out.print("Level " + level + ": ");
                Set<Integer> levelNodes = levelOrderMap.get(level);
                if (levelNodes != null) {
                    for (Integer node : levelNodes) {
                        System.out.print(node + " ");
                    }
                }
                System.out.println();
            }
        } catch (TreeOperationException e) {
            System.out.println("Tree Operation Error: " + e.getMessage());
        }
    }
}