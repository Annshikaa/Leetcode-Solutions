class Solution {
    public boolean canFinish(int num, int[][] p) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < num; i++) {
            adj.add(new ArrayList<>());
        }
        int[] indegree=new int[num];

        for (int i =0;i< p.length;i++) {
            int u=p[i][0];
            int v=p[i][1];
            adj.get(v).add(u);
            indegree[u]++;
        }

        Queue<Integer> q=new LinkedList<>();
        for (int i = 0; i < num; i++) {
            if (indegree[i]==0) {
                q.offer(i);
            }
        }

       int count =0;

        while (!q.isEmpty()) {
            int node=q.poll();
            count++;
            
            for(int nbr:adj.get(node)){
                indegree[nbr]--;
                if(indegree[nbr]==0){
                    q.offer(nbr);
                }
            }
        }

        return count==num;
    }
}