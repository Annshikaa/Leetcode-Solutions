class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        nummap = {}
        n = len(nums)

        for i in range(n):
            nummap[nums[i]] = i

        for i in range(n):
            complement = target - nums[i]
            if complement in nummap and nummap[complement] != i:
                return [i, nummap[complement]]

        return []
        
