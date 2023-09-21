class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int windowSize = Math.min(k, nums.length-1);
        HashSet<Integer> elements = new HashSet<>();
        for(int i = 0; i <= windowSize; i++) {
            if (!elements.add(nums[i]))
                return true;
        }
    
        int i = 0, j = windowSize+1;
        while(j < nums.length) {
            elements.remove(nums[i++]);
            if (!elements.add(nums[j++])) {
                return true;
            }
        }
        return false;

    }
}
