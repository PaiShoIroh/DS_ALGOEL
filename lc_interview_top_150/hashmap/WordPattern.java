class Solution {
    public boolean wordPattern(String pattern, String s) {
        /*
            a -> dog 
            a -> 1,2,4
            dog -> 1,4
        */
        String[] words = s.split(" ");
        if (words.length != pattern.length())
            return false;


        int[] patternFreq = new int[26];
        Map<String, Integer> wordFrequency = new HashMap<>();

        for(int idx = 0; idx < pattern.length(); idx++) {
            int f = 0;
            if(wordFrequency.containsKey(words[idx])) {
                f = wordFrequency.get(words[idx]);
            }
            if (patternFreq[pattern.charAt(idx)-'a'] != f)
                return false;

            patternFreq[pattern.charAt(idx)-'a'] = idx + 1;
            wordFrequency.put(words[idx], idx + 1);
        }
        return true;

    }
}
