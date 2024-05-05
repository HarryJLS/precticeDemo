package com.prectice.responsibilityChainDemo;

/**
 * @author JLS
 * @description:
 * @since 2024-04-24 18:52
 */
public class CheckSlot2 extends BaseSlot {

    @Override
    public void checkThins() {
        System.out.println("CheckSlot2 checkThins");
        check();
    }
}
