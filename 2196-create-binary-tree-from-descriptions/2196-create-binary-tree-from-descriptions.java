class Solution {
    public TreeNode createBinaryTree(int[][] descriptions) {
        Map<Integer, TreeNode> map = new HashMap<>();
        int root = 0;
        for (int[] x : descriptions) {
            if (!map.containsKey(x[0])) {
                map.put(x[0], new TreeNode(x[0]));
                root ^= x[0];
            }
            if (!map.containsKey(x[1])) {
                map.put(x[1], new TreeNode(x[1]));
                root ^= x[1];
            }
            if (x[2] == 1)
                map.get(x[0]).left = map.get(x[1]);
            else
                map.get(x[0]).right = map.get(x[1]);
            root ^= x[1];
        }
        System.out.println(root);
        return map.get(root);
    }
}