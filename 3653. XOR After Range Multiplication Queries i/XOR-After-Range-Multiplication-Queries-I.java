class Solution {
    public int xorAfterQueries(int[] nums, int[][] queries) {
        int MOD = 1000000007;

        // Apply each query one by one
        for (int i = 0; i < queries.length; i++) {
            int l = queries[i][0];
            int r = queries[i][1];
            int k = queries[i][2];
            int v = queries[i][3];

            // Move from l to r with step k
            for (int idx = l; idx <= r; idx += k) {
                long updated = (long) nums[idx] * v;
                nums[idx] = (int) (updated % MOD);
            }
        }

        // Calculate XOR of final array
        int result = 0;
        for (int num : nums) {
            result ^= num;
        }

        return result;
    }
}
