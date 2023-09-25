class Solution {
    private List<List<String>> result;
    private int N;

    public List<List<String>> solveNQueens(int n) {
        result = new ArrayList<>();
        N = n;

        char[][] emptyBoard = new char[N][N];
        for (char[] row : emptyBoard)
            Arrays.fill(row, '.');
        
        backTrack(emptyBoard, 0, 0, 0, 0);
        return result;
    }

    private void backTrack(char[][] board, int row, int cols, int diags, int antiDiags) {
        if (row == N) { // All queens placed
            result.add(toBoard(board));
            return;
        }

        for (int col = 0; col < N; col++) {
            int currDiag = row-col+N;
            int currAntiDiag = row+col;

            if((cols & (1 << col)) != 0 || (diags & (1 << currDiag)) != 0 || (antiDiags & (1 << currAntiDiag)) != 0)
                continue;
            
            board[row][col] = 'Q';
            cols |= (1 << col);
            diags |= (1 << currDiag);
            antiDiags |= (1 << currAntiDiag);

            backTrack(board, row+1, cols, diags, antiDiags);

            board[row][col] = '.';
            cols ^= (1 << col);
            diags ^= (1 << currDiag);
            antiDiags ^= (1 << currAntiDiag);
        }
    }

    private List<String> toBoard(char[][] board) {
        List<String> newBoard = new ArrayList<>();
        for(char row[] : board)
            newBoard.add(new String(row));
        return newBoard;
    }
}
