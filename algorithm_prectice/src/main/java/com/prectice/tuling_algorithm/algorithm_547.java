package com.prectice.tuling_algorithm;

import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author JLS
 * @description: 省份数量
 * @since 2023-08-17 13:02
 */
public class algorithm_547 {

    // 深度优先算法
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
}
