package com.prectice.leetcode;

/**
 * @author JLS
 * @description:
 * @since 2023-10-13 12:39
 */
public class algorithm_24 {
    public ListNode swapPairs(ListNode head) {

        ListNode resultNode = new ListNode(0);
        ListNode tempNode = resultNode;
        while (head != null && head.next != null) {
            int val1 = head.val;
            int val2 = head.next.val;
            tempNode.next = new ListNode(val2, new ListNode(val1));
            tempNode = tempNode.next.next;
            head = head.next.next;
        }
        tempNode.next = head;

        return resultNode.next;


    }

    public ListNode swapPairs1(ListNode head) {
        ListNode temp = head;
        ListNode temp1 = head.next;
        ListNode t = null;
        t = head.next.next;
        temp1.next = temp;
        temp.next = t;
        return head;

    }

    public static void main(String[] args) {
        algorithm_24 algorithm24 = new algorithm_24();
        ListNode data = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
        algorithm24.swapPairs1(data);
    }
}
