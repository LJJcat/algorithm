package leetcode.linked;

/**
 * @author lijingjing
 * @date 2021/8/25 21:00
 */
public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}