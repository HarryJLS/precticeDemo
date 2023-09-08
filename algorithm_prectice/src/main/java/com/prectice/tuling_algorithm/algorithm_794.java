package com.prectice.tuling_algorithm;

/**
 * @author JLS
 * @description:
 * @since 2023-08-25 12:31
 */
public class algorithm_794 {
    public boolean validTicTacToe(String[] board) {
        // 一共分三种情况
        // 1、X赢了 则xCount - oCount = 1；
        // 2、O赢了 则xCount == oCount；
        // 3、都没赢 则xCount - oCount = 1；或  xCount == oCount；

        int xCount = 0;
        int oCount = 0;
        // 遍历棋盘
        for (String item : board) {
            for (char c : item.toCharArray()) {
                if (c == 'X') {
                    xCount++;
                }
                if (c == 'O') {
                    oCount++;
                }
            }
        }
        if (xCount != oCount && xCount - oCount != 1) {
            return false;
        }
        if (xCount - oCount == 1 && win(board, "XXX") && !win(board, "OOO")) {
            return true;
        }
        if (xCount == oCount && win(board, "OOO") && !win(board, "XXX")) {
            return true;
        }
        if (!win(board, "XXX") && !win(board, "OOO")) {
            return true;
        }
        return false;
    }

    private boolean win(String[] board, String target) {
        for (int i = 0; i < 3; i++) {

            String l = "" + board[0].charAt(i) + board[1].charAt(i) + board[2].charAt(i);
            if (l.equals(target)) {
                return true;
            }
            if (board[i].equals(target)) {
                return true;
            }

        }

        // 斜向下
        String downStr = "" + board[0].charAt(0) + board[1].charAt(1) + board[2].charAt(2);
        if (target.equals(downStr)) {
            return true;
        }
        String upStr = "" + board[2].charAt(0) + board[1].charAt(1) + board[0].charAt(2);
        if (target.equals(upStr)) {
            return true;
        }
        return false;
    }
}
