class Solution {
    public List<String> generateParanthesis(int n) {
	List<String> result = new ArrayList<>();
	helper(n, n, result, new StringBuilder());
	return result;
    }

    private void helper(int left, int right, List<String> result, StringBuilder temp) {
	if (left == 0 && right == 0) {
	    result.add(temp.toString());
	    return;
	}

	if (left > 0) {
	    temp.append("(");
	    helper(left-1, right, result, temp);
	    temp.deleteCharAt(temp.length() - 1);
	}

	if (right > 0) {
	    temp.append(")");
	    helper(left, right-1, result, temp);
	    temp.deleteCharAt(temp.length() - 1);
	}
    }
}

