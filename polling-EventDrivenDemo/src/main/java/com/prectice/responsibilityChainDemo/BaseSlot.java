package com.prectice.responsibilityChainDemo;

/**
 * @author JLS
 * @description:
 * @since 2024-04-24 18:29
 */
public abstract class BaseSlot {

    private BaseSlot nextSlot = null;

    public void setNextSlot(BaseSlot nextSlot) {
        this.nextSlot = nextSlot;
    }

    public abstract void checkThins();

    public void check() {
        if (nextSlot != null) {
            nextSlot.checkThins();
        }
    }
}
