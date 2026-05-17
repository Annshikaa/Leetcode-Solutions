class Solution:
    def maximumGap(self, nums: List[int]) -> int:

        if len(nums) < 2:
            return 0

        nums.sort()
        max_diff = 0

        for i in range(len(nums) - 1):

            curr_diff = nums[i + 1] - nums[i]
            if curr_diff > max_diff:
                max_diff = curr_diff
        return max_diff

        