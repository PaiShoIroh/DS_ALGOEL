class Solution {
    public boolean isIsomorphic(String s, String t) {
        
        int[] inputStrMap = new int[256];
        int[] patternMap = new int[256];

        for(int idx = 0; idx < s.length(); idx++) {
            // Check for last occurance of the ascii character
            if (inputStrMap[s.charAt(idx)] != patternMap[t.charAt(idx)])
                return false;
            inputStrMap[s.charAt(idx)] = idx+1;
            patternMap[t.charAt(idx)] = idx+1;
        }
        return true;

    }
}
