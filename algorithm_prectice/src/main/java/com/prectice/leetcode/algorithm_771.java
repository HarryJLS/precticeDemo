package com.prectice.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author JLS
 * @description:
 * @since 2023-07-24 19:52
 */
public class algorithm_771 {

    public int numJewelsInStones(String jewels, String stones) {

        Map<Character, Integer> map = new HashMap<>();
        for (Character c : jewels.toCharArray()) {
            map.put(c, 0);
        }
        for (Character c : stones.toCharArray()) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            }
        }

        int result = 0;
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            result += entry.getValue();
        }

        return result;

    }

    public int numJewelsInStones2(String jewels, String stones) {
        int result = 0;
        for (Character c : stones.toCharArray()) {
            if (jewels.contains(c.toString())) {
                result++;
            }
        }
        return result;
    }
}
