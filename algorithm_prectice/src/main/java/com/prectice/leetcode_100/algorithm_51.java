package com.prectice.leetcode_100;



import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author JLS
 * @description:
 * @since 2023-11-28 13:08
 */
public class algorithm_51 {

    List<List<String>> result = new ArrayList<>();
    LinkedList<String> temp = new LinkedList<>();
    Map<Integer, Integer> map = new HashMap<>();
    volatile boolean isSuccess = true;

    public List<List<String>> solveNQueens(int n) {
        dfs(n, map, 0, -1);
        return result;

    }

    private void dfs (int n, Map<Integer, Integer> map, int col, int t) {
        if (col >= n) {
            checkMap(n);
            if (isSuccess) {
                result.add(new ArrayList<>(temp));
            } else {
                isSuccess = true;
                return;
            }
        }

        for (int i = 0; i < n; i++) {
            if (t != -1 && (i == t+1 || i == t-1)) {
                continue;
            }
            if (map.get(i) == null) {
                temp.addLast(generateStr(i, n));
                map.put(i, col);
                dfs(n, map, col+1, i);
                map.remove(i);
                temp.removeLast();
            }
        }
    }

    private void checkMap(int n) {

        flag:
        for (int i = 0; i < n-1; i++) {
            for (int j = i+1; j < n; j++) {
                if (Math.abs(i-j) == Math.abs(map.get(i) - map.get(j))) {
                    isSuccess = false;
                    break flag;
                }
            }
        }
    }

    private String generateStr(int index, int n) {
        char[] chars = new char[n];
        Arrays.fill(chars, '.'); // 将所有字符初始化为 '.'
        chars[index] = 'Q'; // 在指定索引处放置 'Q'
        return new String(chars);
    }

    public static void main(String[] args) {
        algorithm_51 algorithm51 = new algorithm_51();

        boolean[][] demo = new boolean[4][4];
        demo[0][1] = true;
        demo[1][3] = true;
        demo[2][0] = true;
        demo[3][2] = true;
//        algorithm51.checkMap(demo, 4);

        System.out.println(algorithm51.solveNQueens(9).toString());
    }
}
