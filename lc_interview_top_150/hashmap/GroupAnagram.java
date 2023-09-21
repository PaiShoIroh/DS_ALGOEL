class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> sortedStrToAnaList = new HashMap<>();
        for(String word: strs) {
            String wordSorted = Stream.of(word.split("")).sorted().collect(Collectors.joining());
            sortedStrToAnaList.computeIfAbsent(wordSorted, k -> new ArrayList<>()).add(word);
        }
        List<List<String>> result = new ArrayList<>();
        sortedStrToAnaList.forEach((k,v) -> result.add(v));
        return result;
    }
}
