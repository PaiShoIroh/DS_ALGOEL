class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> indexMap = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            int remainder = target - nums[i];
            if (indexMap.containsKey(remainder)) {
                return new int[] {i, indexMap.get(remainder)};
            } else {
                indexMap.put(nums[i], i);
            }
        }
        return new int[] {};
    }
}
