package Feb29;

import java.util.Scanner;

import java.util.Scanner;

import java.util.Scanner;

class TreeSumException extends Exception {
    public TreeSumException(String message) {
        super(message);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
        left = right = null;
    }
}

class TreeSum {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(7);
        try {
            int result = findSum(root, 0);
            System.out.println("sum = " + result);
        } catch (TreeSumException e) {
            System.out.println("TreeSumException occurred: " + e.getMessage());
        }
    }

    public static int findSum(TreeNode root, int currentSum) throws TreeSumException {
        if (root == null) {
            return 0;
        }

        // Update the current sum with the current node's value
        currentSum = (currentSum * 10 + root.val) % 1003;

        // If the current node is a leaf node, return the current sum
        if (root.left == null && root.right == null) {
            return currentSum;
        }

        // Recursively calculate the sum of all root-to-leaf numbers for left and right subtrees
        int leftSum = 0;
        int rightSum = 0;
        try {
            leftSum = findSum(root.left, currentSum);
        } catch (NullPointerException e) {
            // Handle NullPointerException for left child
            throw new TreeSumException("Left child is null.");
        }
        try {
            rightSum = findSum(root.right, currentSum);
        } catch (NullPointerException e) {
            // Handle NullPointerException for right child
            throw new TreeSumException("Right child is null.");
        }

        // Return the sum of both subtrees
        return (leftSum + rightSum) % 1003;
    }
}
