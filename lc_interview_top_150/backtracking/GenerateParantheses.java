class Solution {
    private List<String> result;

    public List<String> generateParenthesis(int n) {
        result = new ArrayList<>();
        helper(n, 0, "");
        return result;
    }

    private void helper(int left, int right, String s) {
        if (left == 0 && right == 0) {
            result.add(s);
            return;
        }

        if (left > 0)
            helper(left-1, right+1, s + "(");
        if (right > 0)
            helper(left, right-1, s + ")");
    }
}
