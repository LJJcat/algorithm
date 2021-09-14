package leetcode.linked;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 删除链表倒数第 N 个节点
 */
public class DeleteNthEnd19 {

    public static void main(String[] args) {
        DeleteNthEnd19 deleteNthEnd19 = new DeleteNthEnd19();
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
        deleteNthEnd19.removeNthFromEnd2(head,2);
    }


    /**
     * 栈 先进后出
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd2(ListNode head, int n) {
        Deque<ListNode> deque = new LinkedList<ListNode>();

        ListNode result = new ListNode(-1, head);
        ListNode curr = result;
        while (curr != null) {
            deque.push(curr);
            curr = curr.next;
        }

        for (int i = 0; i < n; ++i) {
            deque.pop();
        }
        ListNode prev = deque.peek();
        prev.next = prev.next.next;
        return result.next;

    }




    /**
     * 计算链表长度
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd1(ListNode head, int n) {
        ListNode result = new ListNode(-1, head);
        ListNode curr = result;
        int length = getLength(head);

        for (int i = 0; i < length - n; i++){
            curr = curr.next;
        }
        curr.next = curr.next.next;

        return result.next;
    }

    private int getLength(ListNode head) {
        int length = 0;
        while (head != null) {
            length++;
            head = head.next;
        }
        return length;
    }

}