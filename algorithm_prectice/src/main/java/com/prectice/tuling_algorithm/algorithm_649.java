package com.prectice.tuling_algorithm;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author JLS
 * @description:
 * @since 2023-09-07 12:44
 */
public class algorithm_649 {

    public String predictPartyVictory(String senate) {
        Queue<Integer> r = new LinkedList<>();
        Queue<Integer> d = new LinkedList<>();
        int length = senate.length();
        for (int i = 0; i < length; i++) {
            if (senate.charAt(i) == 'R') {
                r.offer(i);
            } else {
                d.offer(i);
            }
        }
        while (!r.isEmpty() && !d.isEmpty()) {
            int rItem = r.poll();
            int dItem = d.poll();
            if (rItem < dItem) {
                rItem += length;
                r.offer(rItem);
            } else {
                dItem += length;
                d.offer(dItem);
            }
        }
        return r.isEmpty() ? "Dire" : "Radiant";
    }
}
