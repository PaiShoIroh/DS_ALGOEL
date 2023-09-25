class Solution {
    private int N;
    private int count;

    public int totalNQueens(int n) {    
        N = n;
        count = 0;

        char[][] emptyBoard = new char[N][N];
        for (char[] row : emptyBoard)
            Arrays.fill(row, '.');
        
        backTrack(emptyBoard, 0, 0, 0, 0);
        return count;
    }

    private void backTrack(char[][] board, int row, int cols, int diags, int antiDiags) {
        if (row == N) { // All queens placed
            count++;
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
}
