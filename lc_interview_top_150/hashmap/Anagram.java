class Solution {
    public boolean isAnagram(String s, String t) {
        int[] frequency = new int[26];
        for(char ch : s.toCharArray()) {
            frequency[ch-'a']++;
        }
        for(char ch : t.toCharArray()) {
            frequency[ch-'a']--;
        }
        for(int i : frequency) {
            if (i != 0)
                return false;
        }
        return true;
    }
}
