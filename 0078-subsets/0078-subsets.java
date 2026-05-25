class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());

        for (int num : nums) {
            List<List<Integer>> temp_set = new ArrayList<>();

            for (List<Integer> subset : res) {
                List<Integer> newSubSet = new ArrayList<>(subset);
                newSubSet.add(num);
                temp_set.add(newSubSet);
            }

            res.addAll(temp_set);
        }

        return res;
    }
}