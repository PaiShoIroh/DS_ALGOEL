class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        Set<Integer> set = new HashSet<Integer>();
        for(int i : nums)
            set.add(i);
        
        int chain = 0;
        for(int num : nums) {
            int left = num-1;
            int right = num+1;
            while(set.remove(left)) 
                left--;
            while(set.remove(right))
                right++;
            chain = Math.max(chain, right-left-1);
            if (set.isEmpty())
                return chain;
        }
        return chain;
    }
}
