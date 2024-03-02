class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
        left = right = null;
    }
}

public class FlattenBinaryTree {
    // Flatten the binary tree to a linked list in-place.
    public TreeNode flatten(TreeNode root) {
        // Check if the root is null
        if (root == null)
            throw new IllegalArgumentException("Root cannot be null");

        // Create a dummy node to serve as the head of the flattened linked list
        TreeNode dummy = new TreeNode(0);
        // Pointer to the current node in the flattened linked list
        TreeNode current = dummy;

        // Call the recursive helper function to flatten the tree
        flattenHelper(root, current);

        // Return the head of the flattened linked list
        return dummy.right;
    }

    // Recursive helper function to flatten the binary tree.
    private TreeNode flattenHelper(TreeNode root, TreeNode current) {
        // Base case: if the root is null, return the current node
        if (root == null)
            return current;

        // Append the current root node to the flattened linked list
        current.right = root;
        // Move the current pointer to the appended node
        current = root;
        // Store the right child of the current root node
        TreeNode right = root.right;
        // Set the left child of the current root node to null
        current.left = null;
        // Recursively flatten the left subtree, updating the current pointer
        current = flattenHelper(root.left, current);
        // Recursively flatten the right subtree, updating the current pointer
        return flattenHelper(right, current);
    }
}
