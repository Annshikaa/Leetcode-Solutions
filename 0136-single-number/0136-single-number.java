class Solution {
    public int singleNumber(int[] nums) {
        int uniqNum = 0;
        
        for (int idx : nums) {
        
            uniqNum ^= idx;
        } return uniqNum;       
    }
}