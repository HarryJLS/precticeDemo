package com.prectice.leetcode_100;

/**
 * @author JLS
 * @description:
 * @since 2023-11-27 12:36
 */
public class algorithm_79 {

    boolean result = false;
    public boolean exist(char[][] board, String word) {
        int row = board.length;
        int col = board[0].length;
        boolean[][] flag = new boolean[row][col];
        for (int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                if (board[i][j] == word.charAt(0)) {
                    flag[i][j] = true;
                    dfs(board, word, 1, flag, i, j);
                    flag[i][j] = false;
                }
            }
        }

        return result;

    }
    private void dfs(char[][] board, String word, int index, boolean[][] flag, int i, int j) {
        if (index >= word.length()) {
            result = true;
            return;
        }

        if(i > 0 && board[i-1][j] == word.charAt(index) && !flag[i-1][j]) {
            flag[i-1][j] = true;
            dfs(board, word, index+1, flag, i-1, j);
            flag[i-1][j] = false;
        }
        if(i < board.length-1 && board[i+1][j] == word.charAt(index) && !flag[i+1][j]) {
            flag[i+1][j] = true;
            dfs(board, word, index+1, flag, i+1, j);
            flag[i+1][j] = false;
        }
        if(j > 0 && board[i][j-1] == word.charAt(index) && !flag[i][j-1]) {
            flag[i][j-1] = true;
            dfs(board, word, index+1, flag, i, j-1);
            flag[i][j-1] = false;
        }
        if(j < board[0].length-1 && board[i][j+1] == word.charAt(index) && !flag[i][j+1]) {
            flag[i][j+1] = true;
            dfs(board, word, index+1, flag, i, j+1);
            flag[i][j+1] = false;
        }


    }
}
