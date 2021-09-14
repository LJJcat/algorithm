package leetcode.linked;

import java.util.HashSet;

/**
 * 环形链表
 */
public class CycleLinked141 {


    /**
     * hash 缓存
     *
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        HashSet<ListNode> hashSet = new HashSet();
        while (head != null) {
            // 不存在节点可添加入 HashSet ；存在节点不可添加入 HashSet
            if (!hashSet.add(head)) {
                return true;
            }
            head = head.next;
        }
        return false;
    }


    /**
     * 快慢指针
     * 快指针：前进2步
     * 慢指针：亲近1步
     *
     * @param head
     * @return
     */
    public boolean hasCycle1(ListNode head) {
        if (head == null) {
            return false;
        }

        ListNode fast = head.next;
        ListNode slow = head;

        while (fast != slow) {
            if (fast == null || fast.next == null) {
                return false;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        return true;


    }
}