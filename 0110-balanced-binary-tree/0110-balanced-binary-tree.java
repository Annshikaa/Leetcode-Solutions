class Solution {

    public boolean isBalanced(TreeNode root) {
        return height(root) != -1;
    }

    private int height(TreeNode root) {
        // Empty tree is balanced and has height 0
        if (root == null) {
            return 0;
        }

        // Find height of left subtree
        int leftHeight = height(root.left);

        // Left subtree is unbalanced
        if (leftHeight == -1) {
            return -1;
        }

        // Find height of right subtree
        int rightHeight = height(root.right);

        // Right subtree is unbalanced
        if (rightHeight == -1) {
            return -1;
        }

        // Check whether current node is balanced
        if (Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        }

        // Return height of current subtree
        return 1 + Math.max(leftHeight, rightHeight);
    }
}