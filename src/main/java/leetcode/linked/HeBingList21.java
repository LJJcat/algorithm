package leetcode.linked;

/**
 * 合并两个有序链表
 * <p>
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 */
public class HeBingList21 {


    public static void main(String[] args) {
        HeBingList21 fanZhuanList206 = new HeBingList21();
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
        ListNode head2 = new ListNode(1, new ListNode(4, new ListNode(6, new ListNode(7))));

        fanZhuanList206.mergeTwoLists(head, head2);
    }


    /**
     * 递归
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        if (l1.val <= l2.val) {
            l1.next = mergeTwoLists2(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists2(l1, l2.next);
            return l2;
        }
    }


    /**
     * 时间复杂度：O(n+m)，其中 nnn 和 mmm 分别为两个链表的长度。因为每次循环迭代中，l1 和 l2 只有一个元素会被放进合并链表中， 因此 while 循环的次数不会超过两个链表的长度之和。所有其他操作的时间复杂度都是常数级别的，因此总的时间复杂度为 O(n+m)。
     * <p>
     * 空间复杂度：O(1)。我们只需要常数的空间存放若干变量。
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        if (l1 == null && l2 == null) {
            return null;
        }
        ListNode result = new ListNode(-1);
        ListNode curr = result;

        while (l1 != null || l2 != null) {
            if (l1 == null) {
                curr.next = l2;
                l2 = l2.next;
            } else if (l2 == null) {
                curr.next = l1;
                l1 = l1.next;
            } else {
                if (l1.val <= l2.val) {
                    curr.next = l1;
                    l1 = l1.next;
                } else {
                    curr.next = l2;
                    l2 = l2.next;
                }
            }
            curr = curr.next;
        }
        return result.next;

    }


}