class Solution {
    int[] dp;
    public int rob(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }
        dp = new int[nums.length + 1];  
        Arrays.fill(dp, -1); 
        return Math.max(max_robbery(0, nums), max_robbery(1, nums));
    }

    int max_robbery(int currIdx, int[] nums){
        if(currIdx >= nums.length){
            return 0;
        }
        if(dp[currIdx] != -1){
            return dp[currIdx];
        }
        int max = Math.max(nums[currIdx] + max_robbery(currIdx+2, nums) ,nums[currIdx] + max_robbery(currIdx+3, nums));
        dp[currIdx] = max;
        return max;
    }
}