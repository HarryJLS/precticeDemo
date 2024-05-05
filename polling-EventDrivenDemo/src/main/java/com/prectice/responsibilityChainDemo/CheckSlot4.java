package com.prectice.responsibilityChainDemo;

/**
 * @author JLS
 * @description:
 * @since 2024-04-24 18:53
 */
public class CheckSlot4 extends BaseSlot {
    @Override
    public void checkThins() {
        System.out.println("CheckSlot4 checkThins");
        check();
    }
}
