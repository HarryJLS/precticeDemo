package com.prectice.leetcode;

/**
 * @author JLS
 * @description:
 * @since 2023-07-27 14:29
 */
public class algorithm_19 {

    int number = 0;
    int temp = 0;

    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode newHead = new ListNode(1, head);

        // 统计链表节点个数
        countNumber(newHead);
        if (number == 1 && n == 1) {
            return null;
        }
        number = number - n;

        dealListNode(newHead);
        return newHead.next;
    }

    private void countNumber(ListNode head) {
        if (head == null) {
            return;
        }
        number++;
        countNumber(head.next);
    }

    private void dealListNode(ListNode head) {
        if (head == null) {
            return;
        }

        if (++temp == number) {
            head.next = head.next.next;
            return;
        }
        dealListNode(head.next);

    }

    public static ListNode removeNthFromEnd1(ListNode head, int n) {
        ListNode temp = new ListNode(1, head);
        ListNode curData = head;
        ListNode pre = temp;

        for (int i = 0; i < n; i++) {
            curData = curData.next;
        }
        while(curData != null) {
            curData = curData.next;
            pre = pre.next;
        }
        pre.next = pre.next.next;
        return temp.next;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        removeNthFromEnd1(listNode, 1);
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }


}
