class Solution {
    private String reverseString(String word) {
        StringBuilder sb = new StringBuilder(word);  
        sb.reverse();
        return sb.toString();
    }

    public boolean exist(char[][] board, String word) {
        String newWord = reverseString(word);
        char startChar = newWord.charAt(0);

        if (board.length == 1 && board[0].length == 1)
            return board[0][0] == startChar;

        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if (board[i][j] == startChar && findWord(board, newWord, i, j))
                    return true;
            }
        }
        return false;
        
    }

    private boolean findWord(char[][]board, String word, int i, int j) {
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length)
            return false;
        if (word.length() == 0)
            return true;

        char currentChar = board[i][j];
        // System.out.println(currentChar + " row:" + i + " col:" + j);
        char requiredChar = word.charAt(0);
        if (currentChar == '$')
            return false;
        
        if (currentChar != requiredChar)
            return false;

        board[i][j] = '$';
        boolean found = findWord(board, word.substring(1), i+1, j) || 
        findWord(board, word.substring(1), i, j+1) || 
        findWord(board, word.substring(1), i-1, j) || 
        findWord(board, word.substring(1), i, j-1);

        board[i][j] = currentChar;
        return found;
        
    }
}
