package com.prectice.responsibilityChainDemo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author JLS
 * @description: 责任链测试
 * @since 2024-04-24 18:57
 */
public class testDemo {

    public static void main(String[] args) {

        CheckSlot1 checkSlot1 = new CheckSlot1();
        CheckSlot2 checkSlot2 = new CheckSlot2();
        CheckSlot3 checkSlot3 = new CheckSlot3();
        CheckSlot4 checkSlot4 = new CheckSlot4();
        checkSlot1.setNextSlot(checkSlot2);
        checkSlot2.setNextSlot(checkSlot3);
        checkSlot3.setNextSlot(checkSlot4);

        checkSlot1.checkThins();

        List<String> list = new ArrayList<>();
        Iterator<String> iterator = list.iterator();
        iterator.hasNext();
    }
}
