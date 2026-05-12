class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();

        if (nums.length < 4)
            return result;

        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 3; i++) {
            for (int j = i + 1; j < nums.length - 2; j++) {
                int k = j + 1;
                int l = nums.length - 1;

                while (k < l) {
                    long sum = (long) nums[i] + nums[j] + nums[k] + nums[l];
                    if (sum < target) {
                        k++;
                    } else if (sum > target) {
                        l--;
                    } else {
                        result.add(Arrays.asList(nums[i], nums[j], nums[k], nums[l]));
                        k++;
                        l--;

                        while (k < l && nums[k - 1] == nums[k] && nums[l + 1] == nums[l]) {
                            k++;
                            l--;
                        }
                    }
                }

                while (j < nums.length - 2 && nums[j] == nums[j + 1]) {
                    j++;
                }
            }

            while (i < nums.length - 3 && nums[i] == nums[i + 1]) {
                i++;
            }
        }

        return result;
    }
}