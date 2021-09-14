package leetcode.linked;


import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 回文链表
 * 反转以后和以前一样的就是回文结构
 */
public class HuiWenLinked234 {

    public static void main(String[] args) {
        HuiWenLinked234 huiWenLinked234 = new HuiWenLinked234();
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(1))));
        huiWenLinked234.isPalindrome(head);
    }


    /**
     * 后半链表反转，再比较
     *
     * @param head
     * @return
     */
    public boolean isPalindrome2(ListNode head) {
        if (head == null) {
            return true;
        }

        ListNode middleNode = findMiddleNode(head);
        ListNode beforeNode = getBeforeNode(head, middleNode);


        ListNode afterNode = null;


        return false;
    }


    /**
     * 获取前半部分链表
     *
     * @param head
     * @param middleNode
     * @return
     */
    private ListNode getBeforeNode(ListNode head, ListNode middleNode) {
        while (head != middleNode){
            head = head.next;
        }
        return head;
    }

    /**
     * 找到中间节点 以后的链表
     * 快慢指针
     *
     * @param head
     * @return
     */
    private ListNode findMiddleNode(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }


    /**
     * 将值复制到集合中后用双指针法
     *
     * @param head
     * @return
     */
    public boolean isPalindrome(ListNode head) {

        List<Integer> list = new LinkedList();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }

        int length = list.size() / 2;
        for (int i = 0; i < length; i++) {
            int afterIndex = list.size() - 1 - i;
            if (list.get(i) != list.get(afterIndex)) {
                return false;
            }
        }
        return true;

    }


}