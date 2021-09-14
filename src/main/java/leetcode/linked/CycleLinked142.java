package leetcode.linked;

import java.util.HashSet;

/**
 * 环形链表
 * 给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 */
public class CycleLinked142 {


    /**
     * hash 缓存
     *
     * @param head
     * @return
     */
    public ListNode hasCycle(ListNode head) {

        HashSet<ListNode> hashSet = new HashSet();
        while (head != null) {
            // 不存在节点可添加入 HashSet ；存在节点不可添加入 HashSet
            if (!hashSet.add(head)) {
                return head;
            }
            head = head.next;
        }
        return null;
    }


    /**
     * 快慢指针  想法很复杂，会重复n圈
     * 快指针：前进2步
     * 慢指针：前近1步
     *
     * @param head
     * @return
     */
    public ListNode hasCycle1(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode fast = head.next;
        ListNode slow = head;

        while (fast != null) {
            if(fast == slow){
                ListNode result = head;
                while (result != slow){
                    result = result.next;
                    slow = slow.next;
                }
                return result;
            }
            if (fast.next == null) {
                return null;
            }

            fast = fast.next.next;
            slow = slow.next;
        }
        return null;

    }
}