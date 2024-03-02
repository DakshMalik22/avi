class TreeLinkNode {
    int val;
    TreeLinkNode left;
    TreeLinkNode right;
    TreeLinkNode next;

    TreeLinkNode(int val) {
        this.val = val;
        left = right = next = null;
    }
}

public class PopulateNextRightPointer {
    /**
     * Populates each next pointer to point to its next right node.
     * If there is no next right node, the next pointer should be set to NULL.
     * 
     * @param root The root of the binary tree
     */
    public void connect(TreeLinkNode root) throws IllegalArgumentException {
        // Check if the root is null
        if (root == null)
            throw new IllegalArgumentException("Root cannot be null");

        // Initialize a pointer to traverse each level
        TreeLinkNode levelStart = root;

        // Traverse each level of the tree
        while (levelStart != null) {
            // Initialize a pointer to traverse the current level
            TreeLinkNode current = levelStart;

            // Connect nodes of the next level using the next pointers
            while (current != null) {
                // Connect left child's next pointer
                if (current.left != null)
                    current.left.next = current.right != null ? current.right : getNextRight(current);
                // Connect right child's next pointer
                if (current.right != null)
                    current.right.next = getNextRight(current);

                // Move to the next node in the current level
                current = current.next;
            }

            // Move to the next level
            levelStart = getNextLevelStart(levelStart);
        }
    }

    // Helper method to get the next right node
    private TreeLinkNode getNextRight(TreeLinkNode node) {
        // Traverse up the parent chain until we find a parent with a non-null sibling
        while (node.next != null) {
            if (node.next.left != null)
                return node.next.left;
            if (node.next.right != null)
                return node.next.right;
            node = node.next;
        }
        // If no next right node is found, return null
        return null;
    }

    // Helper method to get the start of the next level
    private TreeLinkNode getNextLevelStart(TreeLinkNode node) {
        // Traverse up the parent chain until we find a parent with a non-null child
        while (node != null) {
            if (node.left != null)
                return node.left;
            if (node.right != null)
                return node.right;
            node = node.next;
        }
        // If no next level start is found, return null
        return null;
    }

    // Example usage
    public static void main(String[] args) {
        PopulateNextRightPointer solution = new PopulateNextRightPointer();
        TreeLinkNode root = new TreeLinkNode(1);
        root.left = new TreeLinkNode(2);
        root.right = new TreeLinkNode(3);
        root.left.left = new TreeLinkNode(4);
        root.left.right = new TreeLinkNode(5);
        root.right.left = new TreeLinkNode(6);
        root.right.right = new TreeLinkNode(7);

        solution.connect(root);
        // You can print or traverse the tree to verify the next pointers
    }
}
