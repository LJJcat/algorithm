package leetcode.linked;

/**
 * 反转链表
 */
public class FanZhuanList206 {


    public static void main(String[] args) {
        FanZhuanList206 fanZhuanList206 = new FanZhuanList206();
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));

        fanZhuanList206.reverseList(head);
    }


    /**
     * 迭代
     *

     时间复杂度：O(n)，其中 nnn 是链表的长度。需要遍历链表一次。

     空间复杂度：O(1)。

     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        ListNode result = null;

        if (head == null) {
            return result;
        }

        while (head != null) {
            ListNode curr = head;
            ListNode next = curr.next;
            curr.next = result;
            result = curr;
            head = next;
        }

        return result;
    }

    /**
     * 递归  todo  需要补充
     * @param head
     * @return
     */
    public ListNode reverseList2(ListNode head) {


        return null;


    }
}