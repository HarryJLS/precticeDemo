package com.prectice.leetcode_100_review1.hui_su;

/**
 * @author JLS
 * @description:
 * @since 2024-06-11 12:27
 */
public class algorithm_79 {

    boolean result = false;
    public boolean exist(char[][] board, String word) {

        int row = board.length;
        int col = board[0].length;
        boolean[][] flag = new boolean[board.length][board[0].length];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == word.charAt(0)) {
                    flag[i][j] = true;
                    reverse(i, j, 1, board, flag, word);
                    flag[i][j] = false;
                }

            }
        }



        return result;
    }
    private void reverse(int i, int j, int index, char[][] board, boolean[][] flag, String word) {
        if (index >= word.length()) {
            result = true;
            return;
        }
        int row = board.length;
        int col = board[0].length;
        if (i < row - 1 && !flag[i+1][j] && word.charAt(index) == board[i+1][j]) {
            flag[i+1][j] = true;
            reverse(i+1, j, index+1, board, flag, word);
            flag[i+1][j] = false;
        }
        if (i > 0 && !flag[i-1][j] && word.charAt(index) == board[i-1][j]) {
            flag[i-1][j] = true;
            reverse(i-1, j, index+1, board, flag, word);
            flag[i-1][j] = false;
        }
        if (j < col-1 && !flag[i][j+1] && word.charAt(index) == board[i][j+1]) {
            flag[i][j+1] = true;
            reverse(i, j+1, index+1, board, flag, word);
            flag[i][j+1] = false;
        }
        if (j > 0 && !flag[i][j-1] && word.charAt(index) == board[i][j-1]) {
            flag[i][j-1] = true;
            reverse(i, j-1, index+1, board, flag, word);
            flag[i][j-1] = false;
        }
    }
}
