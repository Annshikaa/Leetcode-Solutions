class Solution {
    List<List<Integer>> result = new ArrayList<>();;

    private void solve(int[] nums, int i, List<Integer> temp) {
        if (i < nums.length) {
            temp.add(nums[i]);
            solve(nums, i + 1, temp);
            temp.remove(temp.size() - 1);
            for (; i + 1 < nums.length && nums[i] == nums[i + 1]; i++);
            solve(nums, i + 1, temp);
        } else {
            result.add(new ArrayList<>(temp));
        }
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        solve(nums, 0, new ArrayList<>());
        return result;
    }
}