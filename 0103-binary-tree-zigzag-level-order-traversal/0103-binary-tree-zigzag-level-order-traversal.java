class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Queue<TreeNode> queue=new LinkedList<TreeNode>();
        List<List<Integer>> ans=new LinkedList<List<Integer>>();
        if(root==null) return ans;
        queue.offer(root);
        while(!queue.isEmpty()){
            List<Integer> sublist=new ArrayList<Integer>();
            int listsize=queue.size();
            for(int i=0;i<listsize;i++){
                TreeNode curr = queue.poll();
                if (curr.left != null) queue.offer(curr.left);
                if (curr.right != null) queue.offer(curr.right);
                sublist.add(curr.val);
            }
            if(ans.size()%2!=0) {
                Collections.reverse(sublist);
                ans.add(sublist);
            }
            else {
                ans.add(sublist);
            }
        }
        return ans;
    }
}