package com.prectice.tuling_algorithm;

import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author JLS
 * @description: 省份数量
 * @since 2023-08-17 13:02
 */
public class algorithm_547 {

    // 深度优先算法
    /**
     * 核心思想：选中一个省份，遍历关联城市的一条线，直到城市再也没有关联为止，然后遍历下一个想关联的城市，遍历的过程就是找一个省份中的所有的城市
     */
    public int findCircleNum(int[][] isConnected) {

        int citys = isConnected.length;
        boolean[] flag = new boolean[citys];
        // 记录数省份的数量
        int provinces = 0;
        for (int i = 0; i < citys; i++) {
            if (!flag[i]) {
                // 访问当前城市所有的关联城市
                dfs(i, citys, isConnected, flag);
                provinces++;
            }
        }
        return provinces;

    }

    private void dfs(int i, int citys, int[][] isConnected, boolean[] flag) {

        for (int j = 0; j < citys; j++) {
            if (isConnected[i][j] == 1 && !flag[j]) {
                flag[j] = true;
                if (i == j) {
                    continue;
                }
                dfs(j, citys, isConnected, flag);
            }
        }
    }

    // 广度优先
    /**
     * 解题思路，首先是选中一个城市，然后遍历与当前城市直接关联的城市，标记一圈后，然后遍历间接关联的城市，遍历完之后就是一个省份确定完
     */
    public int findCircleNum1(int[][] isConnected) {
        int citys = isConnected.length;
        boolean[] flag = new boolean[citys];
        // 记录数省份的数量
        int provinces = 0;
        Queue<Integer> queue = new LinkedList<Integer>();
        for (int i = 0; i < citys; i++) {
            if (!flag[i]) {
                queue.offer(i);
                while (!queue.isEmpty()) {
                    Integer poll = queue.poll();
                    flag[poll] = true;
                    for (int j = 0; j < citys; j++) {
                        if (isConnected[poll][j] == 1 && !flag[j]) {
                            queue.offer(j);
                        }
                    }
                }
                provinces++;
            }
        }
        return provinces;
    }
}
