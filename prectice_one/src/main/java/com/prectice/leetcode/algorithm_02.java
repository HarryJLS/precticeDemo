package com.prectice.leetcode;

/**
 * @author JLS
 * @description: 力扣第2题 两数相加
 * @since 2023-07-02 20:04
 */
public class algorithm_02 {

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        int v1 = 0;
        int v2 = 0;

        int flag = 0;

        ListNode listNode = new ListNode(0);
        // 作为指针移动
        ListNode demo = listNode;
        while (true) {

            v1 = l1 != null ? l1.val : 0;
            v2 = l2 != null ? l2.val : 0;

            if (v1 == 0 && v2 == 0 && flag == 0 && l1 == null && l2 == null) {
                break;
            } else {

                l1 = l1 != null ? l1.next : null;
                l2 = l2 != null ? l2.next : null;
                int sum = v1 + v2 + flag;
                int value = sum % 10;
                flag = sum / 10;

                demo.next = new ListNode(value);
                demo = demo.next;
//                System.out.println(value);
//                listNode = new ListNode(value);
//                listNode = listNode.next;
            }
        }
        return listNode.next;

    }

    public static void main(String[] args) {

        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3)));
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));

        System.out.println(addTwoNumbers(l1, l2));

    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {

    }

    ListNode(int x) {
        val = x;
    }

    ListNode(int x, ListNode next) {
        this.val = x;
        this.next = next;
    }
}
