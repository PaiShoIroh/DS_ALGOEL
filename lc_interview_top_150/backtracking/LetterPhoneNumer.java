class Solution {
    HashMap<Character, List<String>> phone;

    private void init() {
        phone = new HashMap<>();
        phone.put('2', Arrays.asList("a", "b", "c"));
        phone.put('3', Arrays.asList("d", "e", "f"));
        phone.put('4', Arrays.asList("g", "h", "i"));
        phone.put('5', Arrays.asList("j", "k", "l"));
        phone.put('6', Arrays.asList("m", "n", "o"));
        phone.put('7', Arrays.asList("p", "q", "r", "s"));
        phone.put('8', Arrays.asList("t", "u", "v"));
        phone.put('9', Arrays.asList("w", "x", "y", "z"));
    }

    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0)
            return new ArrayList<String>();
        
        init();
        return findCombo(digits);
        
    }

    private List<String> findCombo(String digits) {
        if (digits.length() == 1)
            return phone.get(digits.charAt(0));
        
        List<String> answer = new ArrayList<>();
        List<String> combos = findCombo(digits.substring(1));

        for(String combo : combos) {
            for(String str : phone.get(digits.charAt(0))) {
                answer.add(str + combo);
            }
        }
        return answer;
    }
}
