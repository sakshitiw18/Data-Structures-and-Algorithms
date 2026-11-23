
class Solution {

    public void solveSudoku(char[][] board) {
        solve(board);
    }

    public boolean solve(char[][] board) {

        for (int i = 0; i < 9; i++) {

            for (int j = 0; j < 9; j++) {

                // Find an empty cell
                if (board[i][j] == '.') {

                    // Try digits 1 to 9
                    for (char ch = '1'; ch <= '9'; ch++) {

                        if (isValid(board, i, j, ch)) {

                            // Place the digit
                            board[i][j] = ch;

                            // Recursively solve remaining board
                            if (solve(board)) {
                                return true;
                            }

                            // Backtrack
                            board[i][j] = '.';
                        }
                    }

                    // No digit works
                    return false;
                }
            }
        }

        // All cells are filled
        return true;
    }

    public boolean isValid(char[][] board, int row, int col, char ch) {

        for (int i = 0; i < 9; i++) {

            // Check row
            if (board[row][i] == ch) {
                return false;
            }

            // Check column
            if (board[i][col] == ch) {
                return false;
            }

            // Check 3x3 box
            int r = 3 * (row / 3) + i / 3;
            int c = 3 * (col / 3) + i % 3;

            if (board[r][c] == ch) {
                return false;
            }
        }

        return true;
    }
}

