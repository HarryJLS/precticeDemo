package com.prectice.tuling_algorithm;

/**
 * @author JLS
 * @description:
 * @since 2023-08-10 12:48
 */
public class algorithm_860 {

    public boolean lemonadeChange(int[] bills) {
        int bill_five = 0;
        int bill_ten = 0;
        for (int bill : bills) {
            if (bill == 5) {
                bill_five++;
            } else if (bill == 10) {
                if (bill_five == 0) {
                    return false;
                }
                bill_ten++;
                bill_five--;
            } else {
                if (bill_ten>0 && bill_five > 0) {
                    bill_five--;
                    bill_ten--;
                } else if (bill_five >= 3) {
                    bill_five-=3;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
