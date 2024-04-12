class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class BSTPairFinder {
    public int findPairWithSum(TreeNode root, int targetSum) {
        HashSet<Integer> set = new HashSet<>();
        return hasPair(root, targetSum, set) ? 1 : 0;
    }

    private boolean hasPair(TreeNode node, int target, HashSet<Integer> set) {
        if (node == null) return false;
        if (set.contains(target - node.val)) return true;
        set.add(node.val);
        return hasPair(node.left, target, set) || hasPair(node.right, target, set);
    }
}
